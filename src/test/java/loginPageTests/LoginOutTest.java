package loginPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;


public class LoginOutTest extends AbstractParentTest {

    @Test
    public void validLoginOut() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Student", "909090");
        mainPage.logOut();
        loginPage.checkUnLoggedTitle();

        checkExpectedResult("Logout failed", loginPage.isLoginBoxDisplayed());
    }

}

