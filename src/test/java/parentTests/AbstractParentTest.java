package parentTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import libs.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import parentPage.ParentPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected DictionaryApparatPage dictionaryApparatPage;
    protected DictionaryWorkersPage dictionaryWorkersPage;
    protected DealPage dealPage;
    protected InstallationPage installationPage;
    protected ServicePage servicePage;
    protected StatisticPage statisticPage;
    protected Utils utils;
    protected ParentPage parentPage;
    private String pathToScreenShot;
    Logger log = Logger.getLogger(getClass());

    Properties props = new Properties();

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() throws Exception {

        pathToScreenShot = "..\\Ikonnikov\\target\\screenshot\\" +
                this.getClass().getPackage().getName() + "\\" + this.getClass().getSimpleName() +
                this.testName.getMethodName() + ".jpg";

        webDriver = driverInit();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        dictionaryApparatPage = new DictionaryApparatPage(webDriver);
        dictionaryWorkersPage = new DictionaryWorkersPage(webDriver);
        dealPage = new DealPage(webDriver);
        installationPage = new InstallationPage(webDriver);
        statisticPage = new StatisticPage(webDriver);
        servicePage = new ServicePage(webDriver);
        parentPage = new ParentPage(webDriver);
        utils = new Utils();

    }

    private WebDriver driverInit()  {

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @After
    public void tearDown() {
       webDriver.quit();
    }

    public void checkExpectedResult(String message, boolean actualResult) {
        if(!actualResult == true) {
            utils.screenShot(pathToScreenShot, webDriver);
        }
        Assert.assertEquals(message, true, actualResult);
    }

    public void checkRowsOnListCount(int expected, int rowCount){
        if(expected!= rowCount){
            utils.screenShot(pathToScreenShot, webDriver);
        }
        Assert.assertEquals("Wrong row count", expected, rowCount);
    }

    public void checkCurrentUrl(String message, String actualResult){
        if(!actualResult.equalsIgnoreCase(webDriver.getCurrentUrl())){
            utils.screenShot(pathToScreenShot, webDriver);
        }
        Assert.assertEquals(message, webDriver.getCurrentUrl(), actualResult);
    }

}
