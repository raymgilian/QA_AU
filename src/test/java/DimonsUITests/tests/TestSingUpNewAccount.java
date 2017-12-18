package tests;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.MainPage;

public class TestSingUpNewAccount {

	public  Number randomS = Math.random() * 10000;
	public  String str = new String();

	WebDriver webDriver;
	WebDriverWait wait;
	MainPage mainPage;
	
	@Before	
	public void SingUpSingIn() {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
	webDriver = new ChromeDriver();
	webDriver.manage().window().maximize();
	wait = new WebDriverWait(webDriver, 60);
	
	webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	mainPage=new MainPage(webDriver);
	webDriver.get("https://advantageu.realagentpro.com/");
	mainPage.clickLogin();
	}
	
	@Test
	public void SignIn() {
		mainPage.fillLoginFormEmail("test@bk.ru");
		mainPage.fillLoginFormPassword("123456");
		mainPage.clickSubmitLoginButton();
		mainPage.assertAgentNameIsDisplayed();
	}
	
	@Test
    public  void signUpRealEstateAgent()  {
	mainPage.chooseNewAccountTab();
	mainPage.clickToSelectUserRole();
	mainPage.selectRealEstateAgent();
	mainPage.fillSingUpUserEmail("autotest"+ randomS.toString() + "2@list.ru");
	mainPage.fillSingUpUserPassword("qwerty");
	mainPage.clickChekboxIAmLandlord();
	mainPage.fillSingUpFirstName("Auto");
	mainPage.fillSingUpLastName("Test");
	mainPage.fillSingUpPhone("1234567890");
	mainPage.clickCheckboxIAccept();
	mainPage.submitSignUpForm();
	mainPage.assertCreatedName();
	}
	
	@Test
    public  void signUpSeller()  {
		mainPage.chooseNewAccountTab();
		mainPage.clickToSelectUserRole();
		mainPage.selectSeller();
		mainPage.fillSingUpUserEmail("autotest"+ randomS.toString() + "2@list.ru");
		mainPage.fillSingUpUserPassword("qwerty");
		mainPage.clickChekboxIAmLandlord();
		mainPage.fillSingUpFirstName("Auto");
		mainPage.fillSingUpLastName("Test");
		mainPage.fillSingUpPhone("1234567890");
		mainPage.clickCheckboxIAccept();
		mainPage.submitSignUpForm();
		mainPage.assertCreatedName();	
        }
	
	@Test
    public  void signUpBuyer()  { 	
		mainPage.chooseNewAccountTab();
		mainPage.clickToSelectUserRole();
		mainPage.selectBuyer();
		mainPage.fillSingUpUserEmail("autotest"+ randomS.toString() + "2@list.ru");
		mainPage.fillSingUpUserPassword("qwerty");
		mainPage.clickChekboxIAmLandlord();
		mainPage.fillSingUpFirstName("Auto");
		mainPage.fillSingUpLastName("Test");
		mainPage.fillSingUpPhone("1234567890");
		mainPage.clickCheckboxIAccept();
		mainPage.submitSignUpForm();
		mainPage.assertCreatedName();	
        }
@After
public void tearDown() {
if (webDriver !=null);
webDriver.quit();
	}
}
