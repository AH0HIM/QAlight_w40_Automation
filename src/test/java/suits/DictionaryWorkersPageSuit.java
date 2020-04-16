package suits;

import dictionaryWorkersPageTests.AddNewWorkersTest;
import dictionaryWorkersPageTests.OpenWorkersPageTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
    @Suite.SuiteClasses(
        {
                AddNewWorkersTest.class,
                OpenWorkersPageTest.class,
        }
)
public class DictionaryWorkersPageSuit {

}