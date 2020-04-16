package statisticPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class OpenStatisticPageTest extends AbstractParentTest {

    @Test
    public void OpenStatisticPage() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Student", "909090");
        statisticPage.clickOnLinkToStatisticPage();

        checkExpectedResult("Statistic page header does not display",
                statisticPage.isStatisticHeaderDisplayed());
    }
}
