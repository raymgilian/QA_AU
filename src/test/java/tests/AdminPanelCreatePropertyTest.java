package tests;

import constants.DefaulNewPropertyConstants;
import features.AdminLogin;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AdminPanelCreatePropertyTest extends AdminLogin {
    private String chooseClientPreData = DefaulNewPropertyConstants.CHOOSE_CLIENT_PRE_DATA;
    private String chooseClientDataMail = DefaulNewPropertyConstants.CHOOSE_CLIENT_DATA_MAIL;
    private String chooseClientData = DefaulNewPropertyConstants.CHOOSE_CLIENT_DATA;
    private String chooseAgentPreData = DefaulNewPropertyConstants.CHOOSE_AGENT_PRE_DATA;
    private String chooseAgentData = DefaulNewPropertyConstants.CHOOSE_AGENT_DATA;
    private String title = DefaulNewPropertyConstants.TITLE;
    private String owner = DefaulNewPropertyConstants.OWNER;
    private String mls = DefaulNewPropertyConstants.MLS;
    private String mlsNumber = DefaulNewPropertyConstants.MLS_NUMBER;
    private Boolean active = DefaulNewPropertyConstants.ACTIVE;
    private String preAdress = DefaulNewPropertyConstants.PRE_ADRESS;
    private String adress = DefaulNewPropertyConstants.ADRESS;
    private String propertyType = DefaulNewPropertyConstants.PROPERTY_TYPE;
    private String beds = DefaulNewPropertyConstants.BEDS;
    private int globalI = DefaulNewPropertyConstants.ITERATIONS_TO_TEST;
    private String baths = DefaulNewPropertyConstants.BATHS;
    private String garage = DefaulNewPropertyConstants.GARAGE;
    private String squareFit = DefaulNewPropertyConstants.SQUARE_FIT;
    private String listingPrice = DefaulNewPropertyConstants.LISTING_PRICE;
    private String sellingPrice = DefaulNewPropertyConstants.SELLING_PRICE;


    @Test
    @Ignore
    public void adminCreateNewProperty() {
        $(By.xpath("//*[@id=\"main-menu\"]/li[5]/a")).hover();
        $(By.xpath("//*[@id=\"main-menu\"]/li[5]/ul/li[2]/a")).click();

        $(By.xpath("//*[@id=\"s2id_transaction-id-client\"]/a")).click();
        $(By.xpath("//*[@id=\"s2id_autogen3_search\"]")).setValue(chooseClientPreData);
        $(byText(chooseClientDataMail)).click();
        $(By.xpath("//*[@id=\"s2id_transaction-id-agent\"]/a")).click();
        $(By.xpath("//*[@id=\"property-form\"]/div[3]/div[1]/div/input")).setValue(chooseAgentPreData);
        $(byText(chooseAgentData)).click();
        //$(By.id("s2id_transaction-owner")).click(5,5);
        //$(By.cssSelector("#transaction-owner > option:nth-child(1)")).click();
        $(By.id("property-title")).setValue(title);
        $(By.id("transactioninfo-mls")).setValue(mls);
        $(By.id("transactioninfo-mls_number")).setValue(mlsNumber);

        if (active) {
            $(By.id("transaction-status")).click();
        }

        $(By.xpath("//*[@id=\"property-form\"]/div[3]/div[1]/div/input")).setValue(preAdress);
        $(byText(adress)).click();
        $(By.id("s2id_property-id_type")).click();
        $(byText(propertyType)).click();

        $(By.id("property-beds")).setValue(beds);
        //increase
        for (int i = globalI; i >= 0; i--)
            $(By.xpath("//*[@id=\"property-form\"]/div[4]/div[3]/div[1]/div[1]/div[3]")).click();
        //decrease
        for (int i = globalI; i >= 0; i--)
            $(By.xpath("//*[@id=\"property-form\"]/div[4]/div[3]/div[1]/div[1]/div[2]")).click();

        $(By.id("property-baths")).setValue(baths);
        //increase
        for (int i = globalI; i >= 0; i--)
            $(By.xpath("//*[@id=\"property-form\"]/div[4]/div[5]/div[1]/div[1]/div[3]")).click(5, 5);
        //decrease
        for (int i = globalI; i >= 0; i--)
            $(By.xpath("//*[@id=\"property-form\"]/div[4]/div[5]/div[1]/div[1]/div[2]")).click();

        $(By.id("property-garage")).setValue(garage);
        //increase
        for (int i = globalI; i >= 0; i--)
            $(By.xpath("//*[@id=\"property-form\"]/div[4]/div[7]/div[1]/div[1]/div[3]")).click();
        //decrease
        for (int i = globalI; i >= 0; i--)
            $(By.xpath("//*[@id=\"property-form\"]/div[4]/div[7]/div[1]/div[1]/div[2]")).click();

        $(By.id("property-square_feet")).setValue(squareFit);
        $(By.id("transactioninfo-listing_price")).setValue(listingPrice);
        $(By.id("transactioninfo-selling_price")).setValue(sellingPrice);

        //set dates
        $(By.id("transactioninfo-listing_date")).click();
        $(By.cssSelector("body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-bottom > div.datepicker-days > table > tbody > tr:nth-child(3) > td:nth-child(3)")).click();

        $(By.id("transactioninfo-selling_date")).click();
        $(By.cssSelector("body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-bottom > div.datepicker-days > table > tbody > tr:nth-child(2) > td:nth-child(4)")).click();

        $(By.cssSelector("#property-form > div.row > div > div > input")).click();


        //and Test Results
        $(By.id("select2-chosen-3")).shouldBe(text(chooseClientData));
        $(By.id("select2-chosen-4")).shouldBe(text(chooseAgentPreData));
        $(By.id("select2-chosen-1")).shouldBe(text(owner));
        $(By.id("property-title")).shouldBe(value(title));
        $(By.id("transactioninfo-mls")).shouldBe(value(mls));
        $(By.id("transactioninfo-mls_number")).shouldBe(value(mlsNumber));
        $(By.xpath("//*[@id=\"property-form\"]/div[3]/div[1]/div/input")).shouldBe(value(adress));
        $(By.xpath("//*[@id=\"select2-chosen-2\"]")).shouldBe(text(propertyType));
        $(By.id("property-beds")).shouldBe(value(beds));
        $(By.id("property-baths")).shouldBe(value(baths));
        $(By.id("property-garage")).shouldBe(value(garage));
        $(By.id("property-square_feet")).shouldBe(value(squareFit));
        $(By.id("transactioninfo-listing_price")).shouldBe(value(listingPrice));
        $(By.id("transactioninfo-selling_price")).shouldBe(value(sellingPrice));
    }
}
