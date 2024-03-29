    
package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class Cases extends TestBase {

	@FindBy(xpath="//a[@aria-label='Cases']")
	WebElement Cases;
	@FindBy(xpath="//span[@class='page-header-title']")
	WebElement casesPageHeader;
	@FindBy(xpath="//a[contains(text(),'Add Case')]")
	WebElement addCaseButton;
	@FindBy(xpath="//input[@id='partySearch']")
	WebElement caseRelatedto;
	@FindBy(xpath="//div[@class='searchresult']/ul/li[1]")
	WebElement firstSuggestion;
	@FindBy(xpath="//input[@id='caseNameDecorate:name']")
	WebElement caseName;
<<<<<<< HEAD
	@FindBy(xpath="//span[@class='ui-combobox']/input")
=======
	@FindBy(xpath="//div[@class='addTagComboBox']")
>>>>>>> bc9c7a93450dc0a7c968041114f2e9531ce52000
	WebElement tag;
	@FindBy(xpath="//input[@id='tagsDecorate:j_id191']")
	WebElement Addtag;
	@FindBy(xpath="//input[@id='save']")
    WebElement save;
<<<<<<< HEAD
	@FindBy(xpath="//div[@class='entity-details-title']")
    WebElement caseTitle;
	@FindBy(xpath="//div[@class='kase-summary-status float-left']/span")
    WebElement caseStatus;
	@FindBy(xpath="//a[@class='ember-view']")
    WebElement nameVerification;
	
=======
>>>>>>> bc9c7a93450dc0a7c968041114f2e9531ce52000
	public Cases() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String ClickCasesIcon() throws InterruptedException {
		Cases.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    String titleIs = casesPageHeader.getText();
	   return titleIs;
	}
	
<<<<<<< HEAD
	public String AddCase(String fn, String ln, String caseN, String tagValue) throws InterruptedException {
		addCaseButton.click();
		caseRelatedto.sendKeys(fn + " " + ln);
		Thread.sleep(2000);
		firstSuggestion.click();
		caseName.sendKeys(caseN);
		Thread.sleep(2000);
		tag.sendKeys(tagValue);
		Addtag.click();
		save.click();
	String CaseTitle =	caseTitle.getText();
	return CaseTitle;
=======
	public void AddCase(String fn, String ln, String caseN, String tagValue) {
		addCaseButton.click();
		caseRelatedto.sendKeys(fn + " " + ln);
		caseName.sendKeys(caseN);
		tag.sendKeys(tagValue);
		Addtag.click();
		save.click();
>>>>>>> bc9c7a93450dc0a7c968041114f2e9531ce52000
	}
	public String nameV() {
		String name = nameVerification.getText();
		System.out.println("name is--> " + name);
			return name;
		}
	public String CaseStatus() {
	String caseS =	caseStatus.getText();
	return caseS;
	}
	
}
