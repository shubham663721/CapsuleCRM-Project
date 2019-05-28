package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class AccountSettingsPage extends TestBase {

	@FindBy(xpath="//div[@class='menu-select-selected-option ember-view nav-bar-item nav-bar-account-button']")
	WebElement Accountsdropdown;
	@FindBy(xpath="//a[contains(text(),'Account Settings')]")
	WebElement AccountSettings;
	@FindBy(xpath="//span[@class='settings-content-menu-title']")
	WebElement AccountSettingsPageTitle;
	@FindBy(xpath = "//*[@class='settings-page-header']")
	WebElement settingHeader;
	@FindBy(xpath = "//header[@class='page-box-header']")
	WebElement Header;
	@FindBy(xpath="//input[@id='appearance:uploadDecorate:logoImage']")
	WebElement chooseFile;
	@FindBy(xpath="//input[@id='register:firstnameDecorate:firstName']")
	WebElement firstName;
	@FindBy(xpath="//input[@id='register:lastNameDecorate:lastName']")
	WebElement lastName;
	@FindBy(xpath="//input[@id='register:emailDecorate:email']")
	WebElement email;
	@FindBy(xpath="//input[@id='register:usernameDecorate:username']")
	WebElement userName;
	@FindBy(xpath="//input[@id='register:save']")
	WebElement inviteUser;
	@FindBy(xpath="//a[contains(text(),'Add new User')]")
	WebElement addNewUser;
	
	public AccountSettingsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String selectAccountSettings() {
		Accountsdropdown.click();
		AccountSettings.click();
	String accountSettingPageTitle = AccountSettingsPageTitle.getText();
	return accountSettingPageTitle;
	}
	
	public String clickLinkVerifyTitle(String link) {
		String settingTitle;
		driver.findElement(By.xpath("//li[@class]/a[contains(text(),'"+link+"')]")).click();
		if(link.equalsIgnoreCase("Invoices")){
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			 settingTitle = Header.getText();
		}else if(link.equalsIgnoreCase("Opportunities")) {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			 settingTitle = Header.getText();
		}else {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 settingTitle = settingHeader.getText();
		}
	    return settingTitle;
	}
	public void appearance(String setting) throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//li[@class]/a[contains(text(),'"+setting+"')]")).click();
		chooseFile.click();
		 StringSelection strSel = new StringSelection(System.getProperty("user.dir")+ "\\src\\main\\resources\\OpenButton.PNG");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
			//using Robot class for File upload
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);		
	}
	
	public void users(String User, String FirstName, String LastName, String Email, String UserName) {
		driver.findElement(By.xpath("//li[@class]/a[contains(text(),'"+User+"')]")).click();
		addNewUser.click();
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		email.sendKeys(Email);
		userName.sendKeys(UserName);
		inviteUser.click();
	}
}
