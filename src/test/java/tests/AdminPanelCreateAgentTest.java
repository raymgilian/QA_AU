package tests;

import beans.Agent;
import constants.Constants;
import core.BaseTest;
import org.junit.Test;
import pages.AdminLoginPage;
import pages.AgentsPage;
import pages.CreateAgentPage;

import java.io.InputStream;
import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class AdminPanelCreateAgentTest extends BaseTest{

    @Test
    public void adminCreateNewAgent() {
        Agent expectedAgent = Agent.getFromXml("src/main/resources/agent.xml");
        String email = "autotest" + Long.toString(new Random().nextLong()) + expectedAgent.getEmail();
        expectedAgent.setEmail(email);
        AdminLoginPage adminLoginPage = open(Constants.SITE_AU_ADRESS
                + Constants.SITE_AU_ADMIN_SUBADRESS, AdminLoginPage.class);
        AgentsPage agentsPage = adminLoginPage.login(Constants.SITE_AU_ADMIN_LOGIN, Constants.SITE_AU_ADMIN_PASSWORD);
        CreateAgentPage createAgentPage = agentsPage.goToCreateAgentPage();
        createAgentPage.createAgent(expectedAgent);
        createAgentPage.verifyCreatedAgent(expectedAgent);
    }

}
