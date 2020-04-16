package parentPage;

import libs.ActionWithWebElements;
//import libs.ConfigProperties;
//import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ParentPage {

    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionWithWebElements ActionWithWebElements;
    protected String MainPageUrl = "http://v3.test.itpmgroup.com/";

    @FindBy(xpath = "//li[@id='dictionary']")
    protected WebElement dictionary;

    @FindBy(xpath = "//ul[@class='treeview-menu']/li/a")
    protected List<WebElement> dictionaryTreeMenu;

    @FindBy(id = "dictionary")
    protected WebElement clickdictionary;

    public void clickOndictionary() {
        ActionWithWebElements.clickWebLink(clickdictionary);
    }

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        ActionWithWebElements = new ActionWithWebElements(webDriver);
    }
}
