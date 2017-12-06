package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AgentsPage extends BasicPage {
    SelenideElement menuItem = $(By.xpath("//i[@class='el-adult']"));
    public CreateAgentPage goToCreateAgentPage() {
        menuItem.hover();
        $(By.xpath("//*[@id=\"main-menu\"]/li[3]/ul/li[2]/a/span")).click();
        return page(CreateAgentPage.class);
    }
}
