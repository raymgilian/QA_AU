package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constants.Constants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AdminLoginPage extends BasicPage{
    private SelenideElement loginInput = $(By.id("loginform-email"));
    private SelenideElement passwordInput = $(By.id("loginform-password"));
    private SelenideElement agentListContainer = $(By.xpath("//*[@id=\"agent-list-container\"]"));
    private SelenideElement loginButton = $(By.cssSelector("#login > div:nth-child(6) > button"));

    public AgentsPage login(String login, String password) {
        loginInput.setValue(login);
        passwordInput.setValue(password);
        loginButton.click();
        agentListContainer.waitUntil(Condition.visible, Constants.TIMEOUT);
        return page(AgentsPage.class);
    }
}
