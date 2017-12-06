package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AdminLoginPage extends BasicPage{
    private SelenideElement loginInput = $(By.id("loginform-email"));
    private SelenideElement passwordInput = $(By.id("loginform-password"));

    public AdminLoginPage open() {
        return page(AdminLoginPage.class);
    }

    public AgentsPage login(String login, String password) {
        loginInput.setValue(login);
        passwordInput.setValue(password);
        return page(AgentsPage.class);
    }
}
