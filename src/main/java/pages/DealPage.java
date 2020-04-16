package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

import java.util.List;

public class DealPage extends ParentPage {

    @FindBy(id = "deal")
    protected WebElement linkToDealPage;

    @FindBy(xpath = "//section[@class='content-header']//h1")
    private WebElement dealPageHeader;

    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    private WebElement addDealButton;

    @FindBy(id="deal_dealDate_date_day")
    private WebElement dealDay;

    @FindBy(id="deal_dealDate_date_month")
    private WebElement dealMonth;

    @FindBy(id="deal_dealDate_date_year")
    private WebElement dealYear;

    @FindBy(id="deal_dealDate_time_hour")
    private WebElement dealHour;

    @FindBy(id="deal_dealDate_time_minute")
    private WebElement dealMinute;

    @FindBy(id="deal_dealType")
    private WebElement dealType;

    @FindBy(id="deal_customer")
    private WebElement dealCustomer;

    @FindBy(id="deal_provider")
    private WebElement dealProvider;

    @FindBy(name = "add")
    protected WebElement buttonAdd;

    @FindBy(xpath = "//tr")
    private List<WebElement> dealList;

    public DealPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnLinkToDealPage() {
        ActionWithWebElements.clickWebLink(linkToDealPage);
    }

    public boolean isDealHeaderDisplayed() {
        return ActionWithWebElements.isElementDisplayed(dealPageHeader);
    }

    public void clickAddDealButton(){
        ActionWithWebElements.clickButton(addDealButton);
    }

    public void selectDealDateMonthYearHourMinute(String day, String month, String year, String hour, String minute) {
        ActionWithWebElements.selectElementFromDD(dealDay, day);
        ActionWithWebElements.selectElementFromDD(dealMonth, month);
        ActionWithWebElements.selectElementFromDD(dealYear, year);
        ActionWithWebElements.selectElementFromDD(dealHour, hour);
        ActionWithWebElements.selectElementFromDD(dealMinute, minute);
    }

    public void selectDealType(String dealTypeText) {
        ActionWithWebElements.selectElementFromDD(dealType, dealTypeText);
    }

    public void selectDealCustomer(String customer) {
        ActionWithWebElements.selectElementFromDD(dealCustomer, customer);
    }

    public void selectDealProvider(String provider) {
        ActionWithWebElements.selectElementFromDD(dealProvider, provider);
    }

    public void clickCreateButton() {
        ActionWithWebElements.clickButton(buttonAdd);
    }

    public void createNewDealDictionary(String day, String month, String year, String hour, String minute,
                                        String dealTypeText, String customer, String provider){
        selectDealDateMonthYearHourMinute(day, month, year, hour, minute);
        selectDealType(dealTypeText);
        selectDealCustomer(customer);
        selectDealProvider(provider);
        clickCreateButton();
    }

    public boolean isNewDealDisplayed(
            String dealTypeText, String customer, String provider, String hour, String minute) {
        return getMatchingFromFourColumnsOfTheDealList(dealList, dealTypeText, customer, provider, hour, minute);
    }

    public boolean getMatchingFromFourColumnsOfTheDealList(
            List<WebElement> list, String dealText, String customer, String provider, String hour, String minute) {
        try {
            int listSize = ActionWithWebElements.getSizeList(list) - 1;
            List<WebElement> webElementList = webDriver.findElements(By.xpath("//tr[" + listSize + "]/td"));
            String timeVariable = hour + ":" + minute;
            int counter = 0;
            for(int i = 0; i < webElementList.size(); i++){
                if(webElementList.get(i).getText().equals(dealText) || webElementList.get(i).getText().equals(customer)
                        || webElementList.get(i).getText().equals(provider)
                        || webElementList.get(i).getText().contains(timeVariable)){
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