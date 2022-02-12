package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class HomePage extends BaseClass{

	//@FindBy(how = How.LINK_TEXT,using = "CRM/SFA") WebElement eleCRMSFA;
	public MyHomePage clickCRMSFA() throws IOException
	{
		try {
		getDriver().findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		//eleCRMSFA.click();
		reportStep("Clicked CRMSFA", "Pass");
		}
		catch(Exception e)
		{
			reportStep("Unable to click CRMSFA"+ e.getMessage(), "Fail");
		}
		
		return new MyHomePage();
	}
	//@Then("Home page should be displayed")
	public HomePage verifyHomePage() throws IOException
	{
		
		try {
		boolean displayed = getDriver().findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).isDisplayed();
		
		//boolean displayed = eleCRMSFA.isDisplayed();

		Assert.assertTrue(displayed);
		
		reportStep("Login successful", "Pass");
		}
		catch(Exception e) {
			reportStep("Login unsuccessful"+ e.getMessage(), "Fail");
		}
		return this;
	}
}
