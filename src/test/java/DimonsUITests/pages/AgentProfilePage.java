package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgentProfilePage {
	private WebDriver webDriver;
	private WebDriverWait wait;
	
	@FindBy(id="picture")
	WebElement avatarImage;
	
	@FindBy(xpath="//*[contains(text(),'LIST YOUR PROPERTY')]")
	WebElement listYourPropertyButton;
	
	@FindBy(xpath="//*[@class='modal-body']")
	WebElement modalBodyOfProperty;
	
	public AgentProfilePage(WebDriver driver) {
		webDriver=driver;
		wait = new WebDriverWait(webDriver, 30);
		
		
		PageFactory.initElements(webDriver, this);
	}

public void clickListYourPropertyBtn() {
	listYourPropertyButton.click();
	wait.until(ExpectedConditions.visibilityOf(modalBodyOfProperty));

}

}

