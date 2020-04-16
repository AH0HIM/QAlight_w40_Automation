package suits;

import mainPageTests.ClickOnLinkToMainPageTest;
import mainPageTests.OpenMainPageTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
    @Suite.SuiteClasses(
        {
                ClickOnLinkToMainPageTest.class,
                OpenMainPageTest.class,
        }
)
public class MainPageSuit {

}