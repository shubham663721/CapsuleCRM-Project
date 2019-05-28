package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AccountSettingsPage;
import pages.LoginPage;
import testBase.TestBase;
import util.ExcelUtility;

public class AccountSettingsTestCase extends TestBase {
	LoginPage loginPage;
	AccountSettingsPage accountSettingsPage;
	ExcelUtility excelUtility;
	public AccountSettingsTestCase() {
		super();
	}
	
	@BeforeClass()
	public void setup() {
		Initialization();
		loginPage = new LoginPage();
		accountSettingsPage = new AccountSettingsPage();
		excelUtility = new ExcelUtility();
	}
	
	
	
	@Test()
	public void accountSettings() {
		String titleofPage = loginPage.login();
		 Assert.assertEquals(titleofPage, "Dashboard | self CRM","Title is Incorrect");
		String ASPageTitle = accountSettingsPage.selectAccountSettings();
	    Assert.assertEquals(ASPageTitle, "Account Settings", "Account Settings Page title is incorrect");
	   String accountHeader = accountSettingsPage.clickLinkVerifyTitle("Account");
	    Assert.assertEquals(accountHeader, "Account","Header is not Correct");  
	}
	
	@DataProvider
	public Object[][] getCapsuleCRMTestData() throws IOException{
		Object data[][] = ExcelUtility.getTestData("AccountSettings");
		return data;
	}

	@Test(dataProvider="getCapsuleCRMTestData")
	public void headerValidation(String accountType, String header) {
		System.out.println("account type is--> " + accountType + "Header is--> " + header);
		  String HeaderActual = accountSettingsPage.clickLinkVerifyTitle(accountType);
		  Assert.assertEquals(HeaderActual, header,"Header is not Correct");
	}
	
	public void validateAppearance() throws AWTException, InterruptedException {
		accountSettingsPage.appearance("Appearance");
	}
	
	@DataProvider
	public Object[][] getCapsuleCRMUserTestData() throws IOException{
		Object data[][] = ExcelUtility.getTestData("Users");
		return data;
	}
	
	@Test(dataProvider="getCapsuleCRMUserTestData")
	public void validateUseradded(String fName, String lName, String email, String userN) {
		accountSettingsPage.users("Users", fName, lName, email, userN);
	}
}
