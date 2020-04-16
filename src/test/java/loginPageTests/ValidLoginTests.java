package loginPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class ValidLoginTests extends AbstractParentTest {


    @Test
    public void validLoginWithCorrectLoginAndPassword() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.inputLogin("Student");
        loginPage.inputPassword("909090");
        loginPage.clickSubmitButton();

        checkExpectedResult("Failed to log in", mainPage.isAvatarDisplayed());
    }

    @Test
    public void validLoginWithUpperCaseLogin() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.inputLogin("STUDENT");
        loginPage.inputPassword("909090");
        loginPage.clickSubmitButton();

        checkExpectedResult("Failed to log in", mainPage.isAvatarDisplayed());
    }
}
