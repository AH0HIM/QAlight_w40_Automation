package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class StatisticPage extends ParentPage {

    @FindBy(id = "report")
    protected WebElement linkToStatisticPage;

    @FindBy(xpath = "//section[@class='content-header']//h1")
    private WebElement statisticPageHeader;

    public StatisticPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnLinkToStatisticPage() {
        ActionWithWebElements.clickWebLink(linkToStatisticPage);
    }

    public boolean isStatisticHeaderDisplayed() {
        return ActionWithWebElements.isElementDisplayed(statisticPageHeader);
    }

}
