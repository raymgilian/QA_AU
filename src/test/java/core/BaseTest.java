package core;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.junit.ScreenShooter;
import constants.Constants;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest
{
    @BeforeClass
    public static void setUp()
    {
        System.setProperty("selenide.browser", "chrome");

        //clear cache
        clearBrowserCache();

        Configuration.baseUrl = Constants.SITE_AU_ADRESS;
    }

    @Before
    public void eachTestSetUp()
    {
        //clear cache each test
        if (Constants.CLEAR_CACHE_EACH_TEST)
        {
            clearBrowserCache();
        }
    }

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();
}
