package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class ServicePage extends ParentPage {

    @FindBy(id = "service_apparat")
    protected WebElement linkToServicePage;

    @FindBy(xpath = "//section[@class='content-header']//h1")
    private WebElement servicePageHeader;

    public ServicePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnLinkToServicePage() {
        ActionWithWebElements.clickWebLink(linkToServicePage);
    }

    public boolean isServiceHeaderDisplayed() {
        return ActionWithWebElements.isElementDisplayed(servicePageHeader);
    }
}