package support;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Utilities extends Base {

    private JavascriptExecutor js = (JavascriptExecutor)driver;

    Actions act;

    /**
     * @param locator contains the locator to find single element and
     * @return the desired element
     */
    public WebElement getWebElement(By locator){

        WebElement element = driver.findElement(locator);

        return element;
    }

    /**
     *
     * @param locator will take a locator and find out all the WebElements and
     * @return the lists of it
     */
    public List<WebElement> getListOfWebElements(By locator){

        List<WebElement> listOfElements = driver.findElements(locator);

        return listOfElements;
    }

    public void waitForElement(By locator, int numberOfSeconds){
        WebElement elm = getWebElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(numberOfSeconds));
        wait.until(ExpectedConditions.visibilityOf(elm));
    }

    public void waitToClick(By locator, int numberOfSeconds){
        WebElement elm = getWebElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(numberOfSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(elm));
    }

    public void scrollToElement(By locator){
        WebElement elm = getWebElement(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", elm);
    }

    /**
     * This method scroll the page according to the passing parameter
     *
     * @param position takes the parameter as string 'top' or 'bottom' and scroll the page accordingly
     */
    public void scrollPageTo(String position){

        if (position.equalsIgnoreCase("top")){
            js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        } else if (position.equalsIgnoreCase("bottom")) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        }else {
            System.out.println("[!] Invalid parameter given. Scrolling to the bottom of the page by default.");
            js.executeScript("0, window.scrollTo(document.body.scrollHeight)");
        }

    }

    public Actions hoverOverElement(By locator){
        WebElement elm = getWebElement(locator);
        act = new Actions(driver);
        return act.moveToElement(elm);
    }

    public void selectFromDropdownByVisibleText(By locator, String text){

        Select item = new Select(getWebElement(locator));

        item.selectByVisibleText(text);
    }

}
