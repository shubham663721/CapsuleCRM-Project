package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Cases;
import pages.LoginPage;
import pages.PeopleandOrg;
import testBase.TestBase;
import util.ExcelUtility;

public class CaseStatusVerification extends TestBase {
	LoginPage loginPage;
	PeopleandOrg peopleandOrg;
	ExcelUtility excelUtility;
	Cases cases;
public CaseStatusVerification() {
	super();
}

@BeforeMethod()
public void setup() {
	Initialization();
	loginPage = new LoginPage();
	peopleandOrg = new PeopleandOrg();
	excelUtility = new ExcelUtility();
	cases = new Cases();
}

	/*
	 * @Test() public void caseStatusVerification() throws InterruptedException {
	 * String title = loginPage.login(); Assert.assertEquals(title,
	 * "Dashboard | self CRM","Title is Incorrect"); String peopleTitle =
	 * peopleandOrg.ClickPersonIcon(); Assert.assertEquals(peopleTitle,
	 * "People & Organisations");
	 * 
	 * }
	 */

@DataProvider
public Object[][] getCapsuleCRMTestData() throws IOException{
	Object data[][] = ExcelUtility.getTestData("AddPerson");
	return data;
}

@Test(dataProvider="getCapsuleCRMTestData")
public void validateAddPerson(String title, String firstName, String lastName, String jobTitle, String org, String Phone) throws InterruptedException {
	String titleofPage = loginPage.login();
	Assert.assertEquals(titleofPage, "Dashboard | self CRM","Title is Incorrect");
	String peopleTitle = peopleandOrg.ClickPersonIcon();
    Assert.assertEquals(peopleTitle, "People & Organisations");
	peopleandOrg.addPerson(title, firstName, lastName, jobTitle, org, Phone);
    boolean userAdded =	peopleandOrg.verifyPersonAdded(firstName, lastName);
    Assert.assertTrue(userAdded,"user is not Added");
   String casesTitle = cases.ClickCasesIcon();
   Assert.assertEquals(casesTitle,"Cases", "Title is Incorrect");
   
}
	
}
