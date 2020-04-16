package dealPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class OpenDealPageTest extends AbstractParentTest {

    @Test
    public void OpenApparatPage() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Student", "909090");
        dealPage.clickOnLinkToDealPage();

        checkExpectedResult("Deal page header does not display",
                dealPage.isDealHeaderDisplayed());
    }
}
