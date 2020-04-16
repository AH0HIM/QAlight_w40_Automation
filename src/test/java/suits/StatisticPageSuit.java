package suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import statisticPageTests.OpenStatisticPageTest;


@RunWith(Suite.class)
    @Suite.SuiteClasses(
        {
                OpenStatisticPageTest.class
        }
)
public class StatisticPageSuit {

}