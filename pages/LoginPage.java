package pages;

import org.openqa.selenium.By;
import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginPage extends BaseClass {
	
	@Given("Enter username as {string}")
	public LoginPage enterUserName(String uName)
	{
		getDriver().findElement(By.id("username")).sendKeys(uName);
		return new LoginPage();
	}
	@And("Enter Password as {string}")
	public LoginPage enterPassword(String pass)
	{
		getDriver().findElement(By.id("password")).sendKeys(pass);
		return this;
	}
	@And("Click on Submit button")
	public HomePage clickLogin()
	{
		//Click on Login button
		getDriver().findElement(By.xpath("//input[@type = 'submit']")).click();
		HomePage hp = new HomePage();
		return hp;
	}
	
}
