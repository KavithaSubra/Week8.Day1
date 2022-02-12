package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.MyHomePage;

public class VerifyCreateLead extends BaseClass{
	
	@BeforeTest
	public void setUp()
	{
		fileName="CreateLead";
		testName ="runCreateLead";
		testDescription = "Create Lead with mandatory details";
		author = "Kavitha";
		category = "Smoke";
	}
	
	
	@Test(dataProvider="fetchData")
	public void runCreateLead(String cName, String fName, String lName) throws IOException
	{
		/*new LoginPage()
		.enterUserName("DemoCSR")
		.enterPassword("crmsfa")
		.clickLogin()*/
		new HomePage()
		.verifyHomePage()
		.clickCRMSFA()
		.verifyMyHomePage()
		.clickCreateLead()
		.enterCompName(cName)
		.enterFirstName(fName)
		.enterLastName(lName)
		.clickCreateLeadSubmit()
		.verifyViewLeadPage()
		.verifyFirstName(fName);
	}
}
