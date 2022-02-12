package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import base.BaseClass;

public class ViewLeadPage extends BaseClass {

	public ViewLeadPage verifyViewLeadPage()
	{
		String title = getDriver().getTitle();
		Assert.assertEquals(title, "View Lead | opentaps CRM");
		boolean displayed = getDriver().findElement(By.id("viewLead_firstName_sp")).isDisplayed();
		Assert.assertTrue(displayed);
		return this;
	}
	
	public ViewLeadPage verifyFirstName(String fName)
	{
		String firstName = getDriver().findElement(By.id("viewLead_firstName_sp")).getText();
		Assert.assertEquals(firstName, fName);
		return this;
	}
}
