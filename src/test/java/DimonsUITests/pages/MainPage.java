package pages;

import java.awt.Desktop.Action;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MainPage {
	
	private WebDriver webDriver;
	private WebDriverWait wait;
	
	
	
	@FindBy(xpath="//div[@class='area-text-search']//input[@id='searchagent-query']")
	WebElement mainInputSearchField;
		@FindBy(xpath="//button[contains(text(),'Search')]")
	WebElement mainSearchButton;
		@FindBy(xpath="//li[@class='head-login']/a[@class='open-popup-link']")
	WebElement loginButton;
		@FindBy(xpath="//div[@class='white-popup-sing']")
	WebElement signInSignUpModalWindow;
		@FindBy(id="loginform-email")
	WebElement loginFormEmail;
		@FindBy(id="loginform-password")
	WebElement loginFormPassword;
		@FindBy(xpath="//*[@id='w4']//button[contains(text(),'Submit')]")
	WebElement submitLoginFormButton;	
		@FindBy(xpath="//a[contains(text(),'Test Ermolov')]")
	WebElement loggedInAgentName;
		@FindBy(xpath="//*[@class='header-top-right']//a[contains(text(),'Profile')]")
	WebElement goToAgentProfile;
		@FindBy(xpath="//li[contains(text(),'New account')]")
	WebElement newAccountTab;
		@FindBy(id="select2-user-id_role-container")
	WebElement UserRoleContainer;
		@FindBy(xpath="//li[contains(text(),'Real Estate Agent')]")
	WebElement selectRealEstateAgent;
		@FindBy(id="login_user_email")
	WebElement singUpUserEmailField;
		@FindBy(xpath="//*[@id='user-password_hash']")
		WebElement singUpUserPasswordField;
		@FindBy(xpath="//*[contains(text(),' I am a landlord or industry professional')]")
		WebElement checkboxIAmLandlord;
		@FindBy(xpath="//*[@id='userprofile-first_name']")
		WebElement fieldSingUpFName;
		@FindBy(xpath="//*[@id='userprofile-last_name']")
		WebElement fieldSignUpLastName;
		@FindBy(xpath="//*[@id='login_user_phone_number']")
		WebElement fieldSignUpPhone;
		@FindBy(xpath="//*[contains(text(),'I accept Advantage')]")
		WebElement checkboxIAccept;
		@FindBy(xpath="//*[@id='w5']//button[contains(text(),'Submit')]")
		WebElement submitSignUpForm ;
		@FindBy(xpath="//a[contains(text(),'Auto Test')]")
		WebElement createdUserName;
	@FindBy(xpath="//*[@class='select2-results__option'][contains(text(),'Seller')]")
		WebElement selectSeller;
		@FindBy(xpath="//li[contains(text(),'Buyer')]")
		WebElement selectBuyer;
	public MainPage(WebDriver driver) {
		webDriver=driver;
		wait = new WebDriverWait(webDriver, 30);
		
		PageFactory.initElements(webDriver, this);
	}
	
	public void enterSearchArea(String text) {
		mainInputSearchField.sendKeys(text);
	}
		
	public void clickSearchButton() {
		mainSearchButton.click();
	}
	
	public void clickLogin() {
		loginButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(signInSignUpModalWindow));
	}
	
	public void fillLoginFormEmail(String text) {
		loginFormEmail.sendKeys(text);
	}
	
	public void fillLoginFormPassword(String text) {
		loginFormPassword.sendKeys(text);
	}
	
	public void clickSubmitLoginButton() {
		submitLoginFormButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(loggedInAgentName));	
	}
	
	public void moveTologgedInAgentName() throws InterruptedException {
		 Actions actions = new Actions(webDriver);
		    actions.moveToElement(loggedInAgentName);
		    org.openqa.selenium.interactions.Action action = actions.build();
		    action.perform();   
		    Thread.sleep(2000);
	}
	
	public void clickProfileAndGoToAgentPage() {
		goToAgentProfile.click();
		//wait.until(ExpectedConditions.elementToBeClickable(avatarImage));
	}
	
	public void assertAgentNameIsDisplayed() {
		Assert.assertTrue("еЦН меееееееееер", !webDriver.findElements(By.xpath("//a[contains(text(),'Test Ermolov')]")).isEmpty());
		//Assert.assertTrue(loggedInAgentName is dispaeyd);
	}
	public void chooseNewAccountTab() {
		newAccountTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(UserRoleContainer));
	}
	public void clickToSelectUserRole() {
		UserRoleContainer.click();
	}
	
	public void selectRealEstateAgent() {
		selectRealEstateAgent.click();
	}
	public void fillSingUpUserEmail(String text) {
		singUpUserEmailField.clear();
		singUpUserEmailField.sendKeys(text);
	}
	public void fillSingUpUserPassword(String text) {
		singUpUserPasswordField.sendKeys (text);
	}
	public void clickChekboxIAmLandlord(){
		checkboxIAmLandlord.click();	
	}
	public void fillSingUpFirstName(String text) {
		fieldSingUpFName.sendKeys (text);
	}
	public void fillSingUpLastName(String text) {
		fieldSignUpLastName.sendKeys (text);
	}
	public void fillSingUpPhone(String text) {
		fieldSignUpPhone.sendKeys (text);
	}
	public void clickCheckboxIAccept() {
		checkboxIAccept.click();
	}
	public void submitSignUpForm() {
		submitSignUpForm.click();
		wait.until(ExpectedConditions.elementToBeClickable(createdUserName));
	}
	public void assertCreatedName() {
		Assert.assertTrue("еЦН меееееееееер", !webDriver.findElements(By.xpath("//a[contains(text(),'Auto Test')]")).isEmpty());
	}
	public void selectSeller() {
		selectSeller.click();
	}
	public void selectBuyer() {
		selectBuyer.click();
	}
	public void name() {
		
	}
}