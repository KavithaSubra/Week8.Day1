package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;

public class CreateLeadPage extends BaseClass {

	
	public CreateLeadPage enterCompName(String cName) {
		getDriver().findElement(By.xpath("//input[@id = 'createLeadForm_companyName']")).sendKeys(cName);
		return this;
	}
	
	public CreateLeadPage enterFirstName(String fName) {
		getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		return this;
	}
	
	public CreateLeadPage enterLastName(String lName) {
		getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		return this;
	}
    
	public ViewLeadPage clickCreateLeadSubmit()
	{
		getDriver().findElement(By.name("submitButton")).click();
		return new ViewLeadPage();
	}
}
