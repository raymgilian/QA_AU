package tests;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.MainPage;
import pages.SearchPage;


public class TestSearch  {
	public Number randomS = Math.random() * 10000;
	public String str = new String();
	
	
	WebDriver webDriver;
	WebDriverWait wait;
	JavascriptExecutor jse;
	MainPage mainPage;
	SearchPage searchPage;

	@Before
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
	webDriver = new ChromeDriver();  
		webDriver.manage().window().maximize();
		jse = (JavascriptExecutor)webDriver;
		wait = new WebDriverWait(webDriver, 60);
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mainPage=new MainPage(webDriver);
		searchPage=new SearchPage(webDriver);
		
		webDriver.get("https://advantageu.realagentpro.com/");

		mainPage.enterSearchArea("alaska");
        mainPage.clickSearchButton();
        searchPage.selectSearchStep1Buy();
        searchPage.selectSearchStep2FamilyHome(); 
        searchPage.selectSearchStep3EstimatedValue99999();
        searchPage.selectSearchStep4TimeframeASAP();
        searchPage.selectStep5OnlyBuying();
        searchPage.selectStep5AddStepFamily();  
	}
	
		@Test
	public void invalidEmailCreatingUaccountBySearch()  {
    	 searchPage.fillEmailField("autotest"+ randomS.toString() + "2@list.ruu");		
    	 searchPage.fillPhoneField("1111111111");     
    	 searchPage.fillUserFirstName("Auto");
    	 searchPage.fillUserlastName("Test");
    	 searchPage.clickGenerateMatchesButton();
    	 searchPage.alertMassageWrongEmail();
    	}

	@Test
    public void searchMain()  {
		searchPage.fillEmailField("autotest"+ randomS.toString() + "2@list.ru");
	
        
        webDriver.findElement(By.id("userprofile-phone_number")).sendKeys("1234567890");
        
        webDriver.findElement(By.id("userprofile-first_name")).sendKeys("Auto");
               
        webDriver.findElement(By.id("userprofile-last_name")).sendKeys("Test");
      
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'GENERATE MATCHES')]")));
        webDriver.findElement(By.xpath("//button[contains(text(),'GENERATE MATCHES')]")).click();
                
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Auto Test')]")));
        
        Assert.assertTrue("еЦН меееееееееер", !webDriver.findElements(By.xpath("//a[contains(text(),'Auto Test')]")).isEmpty());
       
       }
	
	@Test
    public void modifySearch() throws InterruptedException  {
		searchPage.fillAreaModifyField("Hawaii, United States");
		
      	webDriver.findElement(By.id("select2-update_role-container")).click();
      	webDriver.findElement(By.xpath("//*[@class='select2-results__option']")).click();
      	webDriver.findElement(By.id("select2-update_property-container")).click();
     	webDriver.findElement(By.xpath("//*[@class='select2-results__option'][1]")).click();
       	webDriver.findElement(By.id("select2-update_estimate-container")).click();
    	webDriver.findElement(By.xpath("//*[@class='select2-results__options']/li[4]")).click();
     	webDriver.findElement(By.id("select2-update_timeframe-container")).click();
       	webDriver.findElement(By.xpath("//*[@class='select2-results__option'][2]")).click();
       	webDriver.findElement(By.xpath("//button[contains(text(),'modify')]")).click();
       	webDriver.findElement(By.xpath("//*[@class='match-button']")).click();
      
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Vladd Dneprov')]")));
        
      Assert.assertTrue("еЦН меееееееееер", !webDriver.findElements(By.xpath("//*[contains(text(),'Vladd Dneprov')]")).isEmpty());
       // String expectedTitle = "User profile";
       // String actualTitle = driver.getTitle();
       // Assert.assertEquals(expectedTitle, actualTitle
       }
   
	@After
   public void tearDown() {
	if (webDriver !=null);
	webDriver.quit();
		
}

}