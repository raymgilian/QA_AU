package pages;

import beans.Agent;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constants.TestData;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CreateAgentPage extends BasicPage {
    private SelenideElement emailInput = $(By.id("user-email-incorrect"));
    //private SelenideElement emailInput = $(By.id("user-email"));
    private SelenideElement firstNameInput = $(By.id("userprofile-first_name"));
    private SelenideElement lastNameInput = $(By.id("userprofile-last_name"));
    private SelenideElement passwordInput = $(By.id("user-password_hash"));
    private SelenideElement licenseNumberInput = $(By.id("userprofile-license_number"));
    private SelenideElement phoneNumberInput = $(By.id("userprofile-phone_number"));
    private SelenideElement educationInput = $(By.id("userprofile-education"));
    private SelenideElement companyInput = $(By.id("userprofile-company"));
    private SelenideElement websiteUrlInput = $(By.id("userprofile-website_url"));
    private SelenideElement userStatus = $(By.id("user-status"));
    private SelenideElement createButton = $(By.xpath("//*[@id=\"w0\"]/div[10]/div/div/button[1]"));

    public CreateAgentPage createAgent(Agent agent) {
        emailInput.setValue(agent.getEmail());
        firstNameInput.setValue(agent.getFirstName());
        lastNameInput.setValue(agent.getLastName());
        passwordInput.setValue(agent.getPassword());
        licenseNumberInput.setValue(agent.getLicenseNumber());
        phoneNumberInput.setValue(agent.getPhoneNumber());
        educationInput.setValue(agent.getEducation());
        companyInput.setValue(agent.getCompany());
        websiteUrlInput.setValue(agent.getWebsite());
        if (agent.isUserStatus()) {
            userStatus.click();
        }
        createButton.click();
        emailInput.should(disappear);
        return page(this);
    }

    public void verifyCreatedAgent(Agent agent) {
        firstNameInput.shouldBe(value(agent.getFirstName()));
        lastNameInput.shouldBe(value(agent.getLastName()));
        //
        licenseNumberInput.shouldBe(value(agent.getLicenseNumber()));
        phoneNumberInput.shouldBe(value(agent.getPhoneNumber()));
        educationInput.shouldBe(value(agent.getEducation()));
        companyInput.shouldBe(value(agent.getCompany()));
        websiteUrlInput.shouldBe(value(agent.getWebsite()));
    }
}
