package dictionaryApparatPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class AddNewApparatTest extends AbstractParentTest {

    @Test
    public void AddNewApparat() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Student", "909090");
        dictionaryApparatPage.clickWebLinkApparat();
        dictionaryApparatPage.createNewApparatDictionary("123", "ApparatTestComment");

        checkExpectedResult("New apparat not added",
                dictionaryApparatPage.isNewApparatDisplayed("123", "ApparatTestComment"));
    }
}
