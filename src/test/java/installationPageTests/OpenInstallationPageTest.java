package installationPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class OpenInstallationPageTest extends AbstractParentTest {

    @Test
    public void OpenApparatPage() {
        BasicConfigurator.configure();

        loginPage.openPageLogin();
        loginPage.loginToSite("Student", "909090");
        installationPage.clickOnLinkToInstallationPage();

        checkExpectedResult("Installation page header does not display",
                installationPage.isInstallationHeaderDisplayed());
    }
}
