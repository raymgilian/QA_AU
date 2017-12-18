package tests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest{
	static WebDriver webDriver;
	static WebDriverWait wait;
	
	
	@BeforeClass
	public static void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		webDriver=new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.get("https://advantageu.realagentpro.com/");
	}
	
	@AfterClass
	public static void tearDown() {
		if (webDriver !=null);
		webDriver.quit();
			
	}
}
