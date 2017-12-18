package tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AgentProfilePage;
import pages.MainPage;

public class TestUserActions {

	WebDriver webDriver;
	WebDriverWait wait;
	MainPage mainPage;
	AgentProfilePage agentProfilePage;
	
	
	@Before
	public void SingUpSingIn() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
	webDriver = new ChromeDriver();
	webDriver.manage().window().maximize();
	wait = new WebDriverWait(webDriver, 60);
	mainPage=new MainPage(webDriver);
	agentProfilePage = new AgentProfilePage(webDriver);
	webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	webDriver.get("https://advantageu.realagentpro.com/");
	mainPage.clickLogin();
	mainPage.fillLoginFormEmail("test@bk.ru");
	mainPage.fillLoginFormPassword("123456");
	mainPage.clickSubmitLoginButton();
	mainPage.moveTologgedInAgentName();
	mainPage.clickProfileAndGoToAgentPage();
	}
	

	
	 
@Test
	public void addProperty() throws InterruptedException {
				
		agentProfilePage.clickListYourPropertyBtn();
		
	}
}
