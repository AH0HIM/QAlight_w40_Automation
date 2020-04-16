package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

import java.util.List;

public class DictionaryApparatPage extends ParentPage {

    @FindBy(xpath = "//tbody//tr/td[1]")
    protected List<WebElement> columnNumber;

    @FindBy(xpath = "//tbody//tr/td[2]")
    protected List<WebElement> columnComment;

    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    protected WebElement addApparatButton;

    @FindBy(id = "apparat_apparatNumber")
    protected WebElement apparatNumber;

    @FindBy(id = "apparat_apparatComment")
    protected WebElement apparatComment;

    @FindBy(name = "add")
    protected WebElement buttonAdd;

    @FindBy(xpath = "//section[@class='content-header']//h1")
    protected WebElement apparatPageHeader;

    public DictionaryApparatPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickWebLinkApparat(){
        ActionWithWebElements.clickOnWebLinkFromTreeMenu(dictionary, dictionaryTreeMenu,"Аппарат");
    }

    public void clickButtonAdd(){
        ActionWithWebElements.clickButton(addApparatButton);
    }

    public void inputApparatNumberField(String number) {
        ActionWithWebElements.enterTextToTextField(apparatNumber, number);
    }

    public void inputApparatCommentField(String comment) {
        ActionWithWebElements.enterTextToTextField(apparatComment, comment);
    }

    public void clickCreateButton() {
        ActionWithWebElements.clickButton(buttonAdd);
    }

    public void createNewApparatDictionary(String number, String comment){
        clickButtonAdd();
        inputApparatNumberField(number);
        inputApparatCommentField(comment);
        clickCreateButton();
    }

    public boolean isNewApparatDisplayed(String number, String column){
        return ActionWithWebElements.getLastTwoColumns(columnNumber, columnComment, number, column);
    }

    public boolean isApparatHeaderDisplayed() {
        return ActionWithWebElements.isElementDisplayed(apparatPageHeader);
    }

}
