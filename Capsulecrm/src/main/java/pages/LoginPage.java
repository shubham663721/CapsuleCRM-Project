package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath="//input[@id='login:usernameDecorate:username']")
	WebElement userName;
	@FindBy(xpath="//input[@id='login:passwordDecorate:password']")
	WebElement password;
	@FindBy(xpath="//input[@id='login:login']")
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String login() {
		userName.sendKeys(prop.getProperty("userName"));
		password.sendKeys(prop.getProperty("password"));
		loginButton.click();
	String title = driver.getTitle();
	return title;
	}
	
}
