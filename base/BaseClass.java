package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utils.ReadExcel;

public class BaseClass extends AbstractTestNGCucumberTests{
	
	private static final ThreadLocal<RemoteWebDriver> tlDriver =  new ThreadLocal<RemoteWebDriver>();
	
	public ExtentReports extent;
	public ExtentTest test, node;
	
	public String testName, testDescription, author, category;
	
	public void setDriver(RemoteWebDriver driver)
	{
		tlDriver.set(driver);
	}
	
	public RemoteWebDriver getDriver()
	{
		 return tlDriver.get();
	}
	
	
	
	//public static RemoteWebDriver driver;
	public String fileName;
	public static Properties prop1;
	@BeforeMethod
	public void preCondition() throws IOException {
		
		node = test.createNode(testName);
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(new File("./src/main/resources/config.properties"));
		prop.load(fis);
		
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		setDriver(new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	
		new LoginPage().enterUserName(prop.getProperty("username"))
		.enterPassword(prop.getProperty("password")).clickLogin();
		
		String lang =prop.getProperty("language");
		
		Properties prop1 = new Properties();
		FileInputStream fis1 = new FileInputStream(new File("./src/main/resources/"+lang+".properties"));
		prop1.load(fis1);
	}
	@AfterMethod
	public void postCondition() {
		//getDriver().close();
	}
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException
	{
		return ReadExcel.readExcel(fileName);
	}
	
	@BeforeSuite
	public void startReport()
	{
		//System.out.println("Test case initiated");
		//setup the physical report path
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		
		//To keep report history
		
		reporter.setAppendExisting(true);
		
		//Create object for extent reporting
		extent = new ExtentReports();
		
		//Attach data with physical report
		extent.attachReporter(reporter);
		
	}
	@BeforeClass
	public void testDetails()
	{
		//Create a test case
		
		test = extent.createTest(testName,testDescription);
				
		//Assign author and category
				
		test.assignAuthor(author);
		test.assignCategory(category);
		
	}
	
	public int takeSnap() throws IOException
	{
		int ranNum = (int)(Math.random()*999999);
		File source = getDriver().getScreenshotAs(OutputType.FILE);
		File target = new File("./images/img"+ranNum+".png");
		FileUtils.copyFile(source,target);
		return ranNum;
	}
	
	public void reportStep(String message, String status) throws IOException
	{
		if(status.equalsIgnoreCase("Pass"))
		{
			node.pass(message,MediaEntityBuilder.createScreenCaptureFromPath(".././images/img"+takeSnap()+".png").build());
		}
		else if(status.equalsIgnoreCase("Fail"))
		{
			node.fail(message,MediaEntityBuilder.createScreenCaptureFromPath(".././images/img"+takeSnap()+".png").build());

			throw new RuntimeException("See Report for details");
		}
	}
	
	@AfterSuite
	public void stopReport()
	{
		extent.flush();
	}
}
