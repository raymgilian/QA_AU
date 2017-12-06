package tests;

import constants.TestData;
import features.AdminLogin;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class AdminPanelCreateAgentTest extends AdminLogin {
    public Number randomS = (int) (Math.random() * 10000);
    public String emailGenerator = new String();

    private String firstName = TestData.CreateAgent.FIRST_NAME;
    private String lastName = TestData.CreateAgent.LAST_NAME;
    private String password = TestData.CreateAgent.DEFAULT_PASSWORD;
    private String licenseNumber = TestData.CreateAgent.LICENSE_NUMBER;
    private String phone = TestData.CreateAgent.PHONE_NUMBER;
    private String education = TestData.CreateAgent.EDUCATION;
    private String company = TestData.CreateAgent.COMPANY;
    private String website = TestData.CreateAgent.WEBSITE;

    @Test
    public void adminCreateNewAgent() {
        //generate random mail
        emailGenerator = "autotest" + randomS.toString() + TestData.CreateAgent.EMAIL_ENDING;

        //go to "create agent" page
        $(By.xpath("//*[@id='main-menu']/li[3]/a/i")).hover();
        $(By.xpath("//*[@id=\"main-menu\"]/li[3]/ul/li[2]/a/span")).click();


        //set agent data
        $(By.xpath("//*[@id=\"user-email\"]")).setValue(emailGenerator);
        $(By.id("userprofile-first_name")).setValue(firstName);
        $(By.id("userprofile-last_name")).setValue(lastName);
        $(By.id("user-password_hash")).setValue(password);
        $(By.id("userprofile-license_number")).setValue(licenseNumber);
        $(By.id("userprofile-phone_number")).setValue(phone);
        $(By.id("userprofile-education")).setValue(education);
        $(By.id("userprofile-company")).setValue(company);
        $(By.id("userprofile-website_url")).setValue(website);
        $(By.id("user-status")).click();


        //todo: add agent bio
        /*
        SelenideElement frameBio = $(By.cssSelector("#cke_1_contents > iframe"));
        frameBio.click();
        switchTo().frame(frameBio);
        //frameBio.setValue(bio);
        //$(By.cssSelector("/html/body")).setValue(bio);
        switchTo().defaultContent();
        sleep(6000);
        */


        //save and create user
        $(By.xpath("//*[@id=\"w0\"]/div[10]/div/div/button[1]")).click();

        //checking for correct agent data
        $(By.id("userprofile-first_name")).shouldBe(value(firstName));
        $(By.id("userprofile-last_name")).shouldBe(value(lastName));
        $(By.id("user-password_hash")).shouldBe(value(password));
        $(By.id("userprofile-license_number")).shouldBe(value(licenseNumber));
        $(By.id("userprofile-phone_number")).shouldHave(value(phone));
        $(By.id("userprofile-education")).shouldBe(value(education));
        $(By.id("userprofile-company")).shouldBe(value(company));
        $(By.id("userprofile-website_url")).shouldBe(value(website));
    }
}
