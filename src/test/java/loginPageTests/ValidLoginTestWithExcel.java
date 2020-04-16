package loginPageTests;

import libs.ConfigClass;
import libs.ExcelDriver;
import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;
import java.io.IOException;
import java.util.Map;

public class ValidLoginTestWithExcel extends AbstractParentTest {



    @Test
    public void validLogin() throws IOException {
        BasicConfigurator.configure();

        Map<String, String> dataForValidLogin = ExcelDriver.getData(
                ConfigClass.getCfgValue("DATA_FILE"), "validLogin");

        loginPage.openPage();
        loginPage.inputLogin(dataForValidLogin.get("login"));
        loginPage.inputPassword(dataForValidLogin.get("pass"));
        loginPage.clickSubmitButton();

        checkExpectedResult("Avatar is not present", mainPage.isAvatarDisplayed());
    }



}
