package suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import servicePageTests.OpenServicePageTest;


@RunWith(Suite.class)
    @Suite.SuiteClasses(
        {
                OpenServicePageTest.class
        }
)
public class ServicePageSuit {

}