package dealPageTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class AddNewDealTest extends AbstractParentTest {

    @Test
    public void OpenApparatPage() {
    BasicConfigurator.configure();

    loginPage.openPageLogin();
    loginPage.loginToSite("Student", "909090");
    dealPage.clickOnLinkToDealPage();
    dealPage.clickAddDealButton();
    dealPage.createNewDealDictionary("31", "дек.", "2020", "23", "59",
            "DealTypeName", "Customer Name", "Name1" );

        checkExpectedResult("The new deal isn't added", dealPage.isNewDealDisplayed
                ("DealTypeName","Customer Name","Name1","23","59"));
    }
}
