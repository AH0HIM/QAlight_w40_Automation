package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ActionWithWebElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait_10, webDriverWait_15;

    public ActionWithWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait_10 = new WebDriverWait(webDriver, 10);
        webDriverWait_15 = new WebDriverWait(webDriver, 15);
    }

    public void enterTextToTextField(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info("Text has been successfully added");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Error adding text to field");
        }
    }

    public void clickButton(WebElement element) {
        try {
            element.click();
            logger.info("The button has been pressed");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("The button was not pressed");
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            webDriverWait_15.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("The error occurred while displaying the element");
            return false;
        }
    }

    public void setCheckBox(WebElement element, boolean state) {
        try {
            if (element.isSelected() == state) {
            } else {
                element.click();
            }
            logger.info("The check box is " + state);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("The error occurred while checkbox state changes");
        }
    }

    public void selectElementFromDD(WebElement element, String itemName) {
        try {
            Select dropDownValue = new Select(element);
            dropDownValue.selectByVisibleText(itemName);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            logger.error("The error occurred while dropdown element selection");
        }
    }

    public void clickWebLink(WebElement element) {
        try {
            element.click();
            logger.info("Link was clicked ");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Error happened during clicking on link");
        }
    }

    public boolean getLastTwoColumns(List<WebElement> column1, List<WebElement> column2,
                                     String ValueColumn1, String ValueColumn2) {
        try {
            String lastColumn1 = column1.get(column1.size() - 1).getText();
            String lastColumn2 = column2.get(column2.size() - 1).getText();
            return lastColumn1.equals(ValueColumn1) && lastColumn2.equals(ValueColumn2);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Something went wrong");
            return false;
        }
    }

    public int getSizeList(List<WebElement> list){
        try {
            return list.size();
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong");
        }
        return -1;
    }

    public void clickOnWebLinkFromTreeMenu(WebElement menuHeader, List <WebElement> elementsList, String text){
        try {
            menuHeader.click();
            int temp = elementsList.size();
            for(int i = 0; i < temp; i++){
                if(elementsList.get(i).getText().equals(text)){
                    elementsList.get(i).click();
                    logger.info("Well done");
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong");
        }
    }
}