package dictionaryWorkersPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class AddNewWorkersTest extends AbstractParentTest {

    @Test
    public void AddNewApparat() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Student", "909090");
        //dictionaryWorkersPage.clickWebLinkWorkers();
        dictionaryWorkersPage.clickOndictionary();
        dictionaryWorkersPage.clickOnLinkToWorkersPage();
        dictionaryWorkersPage.createNewWorkersDictionary(
                "Surname", "Name", "Middle", "123456789");

        checkExpectedResult("New workers not added",
                dictionaryWorkersPage.isNewWorkersDisplayed(
                        "Surname", "Name", "Middle", "123456789"));
    }
}
