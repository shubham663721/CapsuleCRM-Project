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
	@FindBy(xpath="//input[@id='caseNameDecorate:name']")
	WebElement caseName;
	@FindBy(xpath="//div[@class='addTagComboBox']")
	WebElement tag;
	@FindBy(xpath="//input[@id='tagsDecorate:j_id191']")
	WebElement Addtag;
	@FindBy(xpath="//input[@id='save']")
    WebElement save;
	public Cases() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String ClickCasesIcon() throws InterruptedException {
		Cases.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    String titleIs = casesPageHeader.getText();
	   return titleIs;
	}
	
	public void AddCase(String fn, String ln, String caseN, String tagValue) {
		addCaseButton.click();
		caseRelatedto.sendKeys(fn + " " + ln);
		caseName.sendKeys(caseN);
		tag.sendKeys(tagValue);
		Addtag.click();
		save.click();
	}
}
