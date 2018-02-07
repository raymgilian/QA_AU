package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AgentsPage extends BasicPage {
    private SelenideElement menuItem = $(By.xpath("//i[@class=\"el-adult\"]"));
    private SelenideElement subMenuItem = $(By.xpath("//*[@id=\"main-menu\"]/li[4]/ul/li[2]/a/span"));

    public CreateAgentPage goToCreateAgentPage() {
        menuItem.hover();
        subMenuItem.click();
        return page(CreateAgentPage.class);
    }
}
