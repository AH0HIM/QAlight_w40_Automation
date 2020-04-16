package loginPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class InvalidLoginTests extends AbstractParentTest {

    @Test
    public void invalidLoginWithWrongLogin(){
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Admin","909090");
        loginPage.checkUnLoggedTitle();

        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
    }

    @Test
    public void invalidLoginWithWrongPassword(){
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Student","qwerty");
        loginPage.checkUnLoggedTitle();

        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
    }


    @Test
    public void invalidLoginWithEmptyPassword(){
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Student","");
        loginPage.checkUnLoggedTitle();

        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
    }

    @Test
    public void invalidLoginWithEmptyLogin() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("","909090");
        loginPage.checkUnLoggedTitle();

        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
    }

    @Test
    public void invalidLoginWithEmptyLoginAndPassword(){
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("","");
        loginPage.checkUnLoggedTitle();

        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
    }

    @Test
    public void invalidLoginWithCorrectLogAndPassInWrongFields(){
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("909090","Student");
        loginPage.checkUnLoggedTitle();

        checkExpectedResult("LoginBox isn't present", loginPage.isLoginBoxDisplayed());
    }
}

