package utils;

import factory.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils  {
    WebDriver driver = DriverFactory.getDriver();
    Actions actions= new Actions(driver);

    public void clickOnElement(WebElement element)  {
        WebElement webElement = waitForElement(element,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        webElement.click();
    }

    public void typeTextIntoElement(WebElement element, String textToBeTyped) {
        WebElement webElement = waitForElement(element,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(textToBeTyped);
    }

    public WebElement waitForElement(WebElement element, long durationInSeconds) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }

    public void selectOptionInDropdown(WebElement element, String dropDownOption) {
        WebElement webElement = waitForElement(element, CommonUtils.IMPLICIT_WAIT_TIME);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownOption);
    }

    public void acceptAlert() {

        Alert alert = waitForAlert(CommonUtils.IMPLICIT_WAIT_TIME);
        alert.accept();

    }

    public void dismissAlert() {

        Alert alert = waitForAlert(CommonUtils.IMPLICIT_WAIT_TIME);
        alert.dismiss();

    }

    public Alert waitForAlert(long durationInSeconds) {

        Alert alert = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return alert;

    }

    public void mouseHoverAndClick(WebElement element) {
        WebElement webElement = waitForVisibilityOfElement(element, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
       // actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {

        WebElement webElement = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;

    }

    public void javaScriptClick(WebElement element) {

        WebElement webElement = waitForVisibilityOfElement(element, CommonUtils.IMPLICIT_WAIT_TIME);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].click();", webElement);

    }

    public void javaScriptType(WebElement element, String textToBeTyped) {

        WebElement webElement = waitForVisibilityOfElement(element,CommonUtils.IMPLICIT_WAIT_TIME);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);

    }

    public String getTextFromElement(WebElement element) {

        WebElement webElement = waitForElement(element, CommonUtils.IMPLICIT_WAIT_TIME);
        return webElement.getText();

    }

    public boolean displayStatusOfElement(WebElement element) {

        try {
            WebElement webElement = waitForVisibilityOfElement(element,CommonUtils.IMPLICIT_WAIT_TIME);
            return webElement.isDisplayed();
        } catch (Throwable e) {
            return false;
        }

    }

}
