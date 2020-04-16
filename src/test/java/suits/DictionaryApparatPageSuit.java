package suits;

import dictionaryApparatPageTests.AddNewApparatTest;
import dictionaryApparatPageTests.OpenApparatPageTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
    @Suite.SuiteClasses(
        {
                AddNewApparatTest.class,
                OpenApparatPageTest.class,
        }
)
public class DictionaryApparatPageSuit {

}