package mainPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class OpenMainPageTest extends AbstractParentTest {


    @Test
    public void OpeningMainPage() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Student","909090");

        checkExpectedResult("False header is displayed", mainPage.isMainHeaderDisplayed());
        checkRowsOnListCount(5, mainPage.returnContentListCount());
    }
}
