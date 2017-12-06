package features;

import constants.Constants;
import core.BaseTest;
import org.junit.Before;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AdminLogin extends BaseTest {
    private boolean isLogined = false;

    @Before
    public void testAdminLogin() {
        open(Constants.SITE_AU_ADMIN_SUBADRESS);

        if (Constants.NEED_TO_RELOGIN || Constants.CLEAR_CACHE_EACH_TEST || !isLogined) {
            $(By.id("loginform-email")).setValue(Constants.SITE_AU_ADMIN_LOGIN);
            $(By.id("loginform-password")).setValue(Constants.SITE_AU_ADMIN_PASSWORD);
            $(By.cssSelector("#login > div:nth-child(6) > button")).click();
            $(By.xpath("//*[@id=\"agent-list-container\"]")).waitUntil(exist, 5000);
            isLogined = true;
        }

    }
}
