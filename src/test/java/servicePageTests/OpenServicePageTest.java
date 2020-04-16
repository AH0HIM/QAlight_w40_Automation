package servicePageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class OpenServicePageTest extends AbstractParentTest {

    @Test
    public void OpenServicePage() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Student", "909090");
        servicePage.clickOnLinkToServicePage();

        checkExpectedResult("Service page header does not display",
                servicePage.isServiceHeaderDisplayed());
    }
}
