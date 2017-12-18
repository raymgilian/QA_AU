package tests;

import beans.Agent;
import constants.Constants;
import core.BaseTest;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pages.AdminLoginPage;
import pages.AgentsPage;
import pages.CreateAgentPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class AdminPanelCreateAgentTest extends BaseTest{

    @Test
    //@DisplayName("some test name")
    @Description("Some fucking description")
    @Issue("JIRA-123")
    @TmsLink("jira-link")
    @Severity(SeverityLevel.CRITICAL)
    @Category(RegressionTest.NewTest.class)
    public void adminCreateNewAgent() {
        Agent expectedAgent = Agent.getFromXml("src/main/resources/agent.xml");
        String email = "autotest" + Long.toString(new Random().nextLong()) + expectedAgent.getEmail();
        expectedAgent.setEmail(email);
        AgentsPage agentsPage = login();
        CreateAgentPage createAgentPage = createAgent(agentsPage, expectedAgent);
        verifyAgentData(createAgentPage, expectedAgent);
    }

    @Step
    public AgentsPage login() {
        AdminLoginPage adminLoginPage = open(Constants.SITE_AU_ADRESS
                + Constants.SITE_AU_ADMIN_SUBADRESS, AdminLoginPage.class);
        return adminLoginPage.login(Constants.SITE_AU_ADMIN_LOGIN, Constants.SITE_AU_ADMIN_PASSWORD);
    }

    @Step
    public CreateAgentPage createAgent(AgentsPage agentsPage, Agent agent) {
        CreateAgentPage createAgentPage = agentsPage.goToCreateAgentPage();
        return createAgentPage.createAgent(agent);
    }

    @Step
    public void verifyAgentData(CreateAgentPage createAgentPage, Agent expectedAgent) {
        createAgentPage.verifyCreatedAgent(expectedAgent);
    }
}
