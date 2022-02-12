package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import base.BaseClass;

public class MyHomePage extends BaseClass {

	
	public MyHomePage verifyMyHomePage()
	{
	String title = getDriver().getTitle();
	Assert.assertEquals(title, "My Home | opentaps CRM");
	return this;
	}
	
	public CreateLeadPage clickCreateLead() {
		getDriver().findElement(By.xpath("//a[text()='Create Lead']")).click();
		//getDriver().findElement(By.linkText(prop1.getProperty("Leads_Link_Text"))).click();

		//getDriver().findElement(By.linkText(prop1.getProperty("Create_Leads_Link_Text"))).click();
		
		CreateLeadPage clp = new CreateLeadPage();
		return clp;
	}
	

}
