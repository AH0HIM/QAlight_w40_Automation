package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import pageElements.LeftMenu;
import parentPage.ParentPage;

import java.util.List;

public class MainPage extends ParentPage {

    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

    @FindBy(xpath = ".//li[@id='dictionary']//ul[@class='treeview-menu menu-open']//li[@id='prov_cus']")
    private WebElement submenuProviders;

    @FindBy(xpath = "//a[@href='/logout']")
    protected WebElement logOutButton;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    protected WebElement dropdownMenuToggle;

    @FindBy(xpath = "//section[@class='content-header']//h1")
    protected WebElement mainPageHeader;

    @FindBy(xpath = "//div[@class='content-wrapper']//p")
    protected List<WebElement> contentList;

    @FindBy(xpath = "//a[@href='/']")
    protected WebElement linkToMainPage;

    String TitleMain = "Учет запчастей";

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarDisplayed() {
        return ActionWithWebElements.isElementDisplayed(avatar);
    }

    public void checkIsAvatarPresent() {
        Assert.assertTrue("Avatar is not displayed", isAvatarDisplayed());
    }

    public void clickOnSubmenuProviders() {
        ActionWithWebElements.clickButton(submenuProviders);
    }

    public void checkLoggedTitle() {
        Assert.assertEquals(webDriver.getTitle(), TitleMain);
    }

    public void logOut() {
        ActionWithWebElements.clickButton(dropdownMenuToggle);
        ActionWithWebElements.clickButton(logOutButton);
    }
    public int returnContentListCount() {
        return contentList.size();
    }
    public boolean isMainHeaderDisplayed() {
        return ActionWithWebElements.isElementDisplayed(mainPageHeader);
    }

    public void clickOnLinkToMainPage() {
        ActionWithWebElements.clickWebLink(linkToMainPage);
    }

    public String getMainPageUrl() {
        return MainPageUrl;
    }
}
