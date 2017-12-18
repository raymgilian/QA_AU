package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	private WebDriver webDriver;
	private WebDriverWait wait;
	private JavascriptExecutor jse;
	
	@FindBy(xpath="//div[@id='step_1']/div/div[1]/a")
	WebElement step1Buy;
	@FindBy(xpath="//div[@id='step_2']/div/div[1]/a")
	WebElement step2FamilyHome;
	@FindBy(xpath="//div[@id='step_3']/div/div[1]/a")
	WebElement step3Value99999;
	@FindBy(xpath="//div[@id='step_4']/div/div[1]/a")
	WebElement step4ASAP;
	@FindBy(xpath="//div[@id='step_5']//span[contains(text(),'Only Buying')]")
	WebElement step5OnlyBuying;
	@FindBy(xpath="//div[@id='step_5']//span[contains(text(),'Family')]")
	WebElement step5AddStepFamily;
	@FindBy(id="user-email")
	WebElement searchUserEmail;
	@FindBy(xpath="//input[@id='update_query']")
	WebElement areaModifyField;
	@FindBy(id="userprofile-phone_number")
	WebElement userphonenumberField;
	@FindBy(id="userprofile-first_name")
	WebElement userFirstNameField;
	@FindBy(id="userprofile-last_name")
	WebElement userLustNameField;
	@FindBy(xpath="//button[contains(text(),'GENERATE MATCHES')]")
	WebElement generateMatchesButton;
	@FindBy(xpath="//p[@class='help-block help-block-error'][contains(text(),'Email is not a valid email address.')]")
	WebElement alertWrongEmail;
	
	
	
	
	
	
	public SearchPage(WebDriver driver) {
		webDriver=driver;
		wait = new WebDriverWait(webDriver, 30);
		jse = (JavascriptExecutor)webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public void selectSearchStep1Buy() {
		wait.until(ExpectedConditions.elementToBeClickable(step1Buy));
		step1Buy.click();
	}

	public void selectSearchStep2FamilyHome() {
		wait.until(ExpectedConditions.elementToBeClickable(step2FamilyHome));
		step2FamilyHome.click();  
	}
	
	public void selectSearchStep3EstimatedValue99999(){
		wait.until(ExpectedConditions.elementToBeClickable(step3Value99999));
		step3Value99999.click();
}
	public void selectSearchStep4TimeframeASAP() {
		wait.until(ExpectedConditions.elementToBeClickable(step4ASAP));
        step4ASAP.click();
	}
	public void selectStep5OnlyBuying() {
		wait.until(ExpectedConditions.elementToBeClickable(step5OnlyBuying));
		step5OnlyBuying.click();
	}
	public void selectStep5AddStepFamily() {
		wait.until(ExpectedConditions.elementToBeClickable(step5AddStepFamily));
		step5AddStepFamily.click();
	}
	public void fillEmailField(String text) {
		wait.until(ExpectedConditions.elementToBeClickable(searchUserEmail));
		searchUserEmail.clear();       
		searchUserEmail.sendKeys(text);
	}
	 public void fillAreaModifyField(String text) throws InterruptedException {
		// webDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		// areaModifyField.isEnabled() ;
		 jse.executeScript("arguments[0].scrollIntoView(true);",areaModifyField);
		 Thread.sleep(2000);	
		 areaModifyField.click();
		 areaModifyField.clear();
		 areaModifyField.sendKeys(text);
	 }
public void fillPhoneField(String text) {
	userphonenumberField.sendKeys(text);
}

public void fillUserFirstName(String text) {
	userFirstNameField.sendKeys(text);
    }
public void fillUserlastName(String text) {
	userLustNameField.sendKeys(text);
}

public void clickGenerateMatchesButton() {
	 wait.until(ExpectedConditions.elementToBeClickable(generateMatchesButton));
	 generateMatchesButton.click();
}

public void alertMassageWrongEmail() {
	//wait.until(ExpectedConditions.visibilityOf(alertWrongEmail));
	 Assert.assertTrue("Error message should be present", 
			 alertWrongEmail.isDisplayed());
}


}




