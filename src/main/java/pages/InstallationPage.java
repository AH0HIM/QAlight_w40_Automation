package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class InstallationPage extends ParentPage {

    @FindBy(id = "installation")
    protected WebElement linkToInstallationPage;

    @FindBy(xpath = "//section[@class='content-header']//h1")
    private WebElement installationPageHeader;

    public InstallationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnLinkToInstallationPage() {
        ActionWithWebElements.clickWebLink(linkToInstallationPage);
    }

    public boolean isInstallationHeaderDisplayed() {
        return ActionWithWebElements.isElementDisplayed(installationPageHeader);
    }
}
