package testcases;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.MediaEntityBuilder;

public class LearnExtentReport {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Test case initiated");
		//setup the physical report path
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		
		//To keep report history
		
		reporter.setAppendExisting(true);
		
		//Create object for extent reporting
		ExtentReports extent = new ExtentReports();
		
		//Attach data with physical report
		extent.attachReporter(reporter);
		
		//Create a test case
		
		ExtentTest test = extent.createTest("Create Lead","Create Lead with mandatory fields" );
		
		//Assign author and category
		
		test.assignAuthor("Kavitha");
		test.assignCategory("Smoke");
		
		//Providing Step level status
		test.pass("Enter Username");
		test.pass("Enter password");
		test.fail("Click Login");
		
		
		//Create a test case
		
				ExtentTest test1 = extent.createTest("Edit Lead","Editing a Lead" );
				
				//Assign author and category
				
				test1.assignAuthor("Kavitha");
				test1.assignCategory("Smoke");
				
				//Providing Step level status
				test1.pass("Enter Username", MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/login.png").build());
				test1.pass("Enter password");
				test1.pass("Click Login");
		
		// Flush report(Mandatory)
		
		extent.flush();
	}
}
