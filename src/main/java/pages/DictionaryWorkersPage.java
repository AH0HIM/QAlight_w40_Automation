package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

import java.util.List;

public class DictionaryWorkersPage extends ParentPage {

    @FindBy(xpath = "//section[@class='content-header']//h1")
    protected WebElement workersPageHeader;

    @FindBy(id = "workers")
    protected WebElement linkToWorkersPage;

    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    protected WebElement addWorkersButton;

    @FindBy(id = "workers_workerSurname")
    protected WebElement WorkersNumberSurname;

    @FindBy(id = "workers_workerName")
    protected WebElement WorkersName;

    @FindBy(id = "workers_workerMiddleName")
    protected WebElement WorkersMiddleName;

    @FindBy(id = "workers_workerPhone")
    protected WebElement WorkersPhone;

    @FindBy(name = "add")
    protected WebElement buttonAdd;

    @FindBy(xpath = "//tbody//tr[1]/td[1]")
    protected List<WebElement> columnWorkers;

    @FindBy(xpath = "//tbody//tr[1]/td[2]")
    protected List<WebElement> columnPhone;

    @FindBy(xpath = "//tr")
    protected List<WebElement> workersList;

    public void clickButtonAdd(){
        ActionWithWebElements.clickButton(addWorkersButton);
    }

    public void inputWorkersSurnameField(String text) {
        ActionWithWebElements.enterTextToTextField(WorkersNumberSurname, text);
    }

    public void inputWorkersNameField(String text) {
        ActionWithWebElements.enterTextToTextField(WorkersName, text);
    }

    public void inputWorkersMiddleNameField(String text) {
        ActionWithWebElements.enterTextToTextField(WorkersMiddleName, text);
    }

    public void inputWorkersPhoneField(String number) {
        ActionWithWebElements.enterTextToTextField(WorkersPhone, number);
    }

    public void clickCreateButton() {
        ActionWithWebElements.clickButton(buttonAdd);
    }

    public DictionaryWorkersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickWebLinkWorkers(){
        ActionWithWebElements.clickOnWebLinkFromTreeMenu(dictionary, dictionaryTreeMenu,"Сотрудники");
    }

    public void clickOndictionary() {
        ActionWithWebElements.clickWebLink(clickdictionary);
    }


    public void clickOnLinkToWorkersPage() {
        ActionWithWebElements.clickWebLink(linkToWorkersPage);
    }

    public boolean isWorkersHeaderDisplayed() {
        return ActionWithWebElements.isElementDisplayed(workersPageHeader);
    }

    public void createNewWorkersDictionary(String Surname, String Name, String Middle, String Phone){
        clickButtonAdd();
        inputWorkersSurnameField(Surname);
        inputWorkersNameField(Name);
        inputWorkersMiddleNameField(Middle);
        inputWorkersPhoneField(Phone);
        clickCreateButton();
    }

    public boolean isNewWorkersDisplayed(
            String surname, String name, String middle, String phone) {
        return getMatchingFromFourColumnsOfTheWorkersList(workersList, surname, name, middle, phone);
    }

    public boolean getMatchingFromFourColumnsOfTheWorkersList(
            List<WebElement> list, String surname, String name, String middle, String phone) {
        try {
            int listSize = ActionWithWebElements.getSizeList(list) - 1;
            List<WebElement> webElementList = webDriver.findElements(By.xpath("//tr[" + listSize + "]/td"));
            String workersBox = surname + " " + name + " " + middle;
            int counter = 0;
            for(int i = 0; i < webElementList.size(); i++){
                if(webElementList.get(i).getText().equals(phone) ||
                        webElementList.get(i).getText().contains(workersBox)){
                    counter++;
                }
            }
            return counter == webElementList.size();

        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong");
            return false;
        }
    }
}
