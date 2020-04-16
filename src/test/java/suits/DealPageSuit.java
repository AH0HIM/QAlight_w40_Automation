package suits;

import dealPageTests.AddNewDealTest;
import dealPageTests.OpenDealPageTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
    @Suite.SuiteClasses(
        {
                AddNewDealTest.class,
                OpenDealPageTest.class,
        }
)
public class DealPageSuit {

}