package dictionaryApparatPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class OpenApparatPageTest extends AbstractParentTest {

    @Test
    public void OpenApparatPage() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Student", "909090");
        dictionaryApparatPage.clickWebLinkApparat();

        checkExpectedResult("Apparat page header does not display",
                dictionaryApparatPage.isApparatHeaderDisplayed());

    }
}
