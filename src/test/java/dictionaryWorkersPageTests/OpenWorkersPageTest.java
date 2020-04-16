package dictionaryWorkersPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class OpenWorkersPageTest extends AbstractParentTest {

    @Test
    public void OpenWorkersPage() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Student", "909090");
        //dictionaryWorkersPage.clickWebLinkWorkers();
        dictionaryWorkersPage.clickOndictionary();
        dictionaryWorkersPage.clickOnLinkToWorkersPage();

        checkExpectedResult("Workers page header does not display",
                dictionaryWorkersPage.isWorkersHeaderDisplayed());

    }
}
