package mainPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class ClickOnLinkToMainPageTest extends AbstractParentTest {

        @Test
        public void clickOnLinkToMainPage() {
            BasicConfigurator.configure();

            loginPage.openPageLogin();
            loginPage.loginToSite("Student", "909090");
            mainPage.clickOnLinkToMainPage();

            checkCurrentUrl("Invalid page open", mainPage.getMainPageUrl());
        }
}