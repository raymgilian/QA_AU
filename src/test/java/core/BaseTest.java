package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.junit.ScreenShooter;
import com.google.common.io.Files;
import constants.Constants;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTest {
    @Rule
    public final TestRule watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            try {
                failedScreenshot();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    };

    @BeforeClass
    public static void setUp() {
        System.setProperty("selenide.browser", "chrome");

        //clear cache
        clearBrowserCache();

        Configuration.baseUrl = Constants.SITE_AU_ADRESS;
    }

    @Before
    public void eachTestSetUp() {
        //clear cache each test
        if (Constants.CLEAR_CACHE_EACH_TEST) {
            clearBrowserCache();
        }
    }

    @Attachment(type = "image/png", value = "Step start screenshot")
    public byte[] stepStartScreenshot() throws IOException {
        Screenshots.takeScreenShot("test.png");
        File screenshot = Screenshots.getLastScreenshot();
        return Files.toByteArray(screenshot);
    }
    @Attachment(type = "image/png", value = "Step finished screenshot")
    public byte[] stepFinishedScreenshot() throws IOException {
        Screenshots.takeScreenShot("test.png");
        File screenshot = Screenshots.getLastScreenshot();
        return Files.toByteArray(screenshot);
    }

    @Attachment(type = "image/png", value = "Screenshot on failure")
    public byte[] failedScreenshot() throws IOException {
        Screenshots.takeScreenShot("failed.png");
        File screenshot = Screenshots.getLastScreenshot();
        return Files.toByteArray(screenshot);
    }
}
