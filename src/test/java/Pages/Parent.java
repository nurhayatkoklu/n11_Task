package Pages;

import Utilities.GeneralWebDriver;
import junit.framework.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Parent {

    public void sendKeysFunction(WebElement element, String value) {//3.Aşama


        waitUntilVisible(element);
     //   scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(GeneralWebDriver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GeneralWebDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickFunction(WebElement element)
    {
        waitUntilVisible(element);
        scrollToElement(element);
        waitUntilClickable(element);
        element.click();
    }

    public void waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(GeneralWebDriver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void verifyContainsText(WebElement element, String text)
    {
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }
    public void selectAndFind(WebElement element, String text)
    {
        Select menu = new Select(element);
        menu.selectByVisibleText(text);
    }
    public List<WebElement> waitVisibleListAllElement(List<WebElement> elementList) {
        WebDriverWait wait = new WebDriverWait(GeneralWebDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }
    public void actionFunction(WebElement element){
        Actions actions = new Actions(GeneralWebDriver.getDriver());
        waitUntilClickable(element);
        Action action=actions.moveToElement(element).click().build();
        action.perform();

    }




}
