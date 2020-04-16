package suits;

import loginPageTests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.LoginPage;


@RunWith(Suite.class)
    @Suite.SuiteClasses(
        {
                ValidLoginTests.class,
                LoginPage.class,
                InvalidLoginTests.class,
                LoginOutTest.class,
                ValidLoginTestWithExcel.class
        }
)
public class LoginPageSuit {

}