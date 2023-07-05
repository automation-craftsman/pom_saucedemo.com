package pages;

import base.Base;
import org.openqa.selenium.By;
import support.Utilities;

public class PurchaseInfoPage extends Base {

    private By firstNameField = By.xpath("//input[@id='first-name']");
    private By lastNameField = By.xpath("//input[@id='last-name']");
    private By postalCodeField = By.xpath("//input[@id='postal-code']");
    private By continueButton = By.xpath("//input[@id='continue']");

    private By pageHeader = By.xpath("//span[contains(text(),'Checkout: Your Information')]");

    Utilities util = new Utilities();

    public String getPageHeader(){

        return util.getWebElement(pageHeader).getText();
    }

    public PurchaseOverviewPage fillPurchaseInfoAndProceed(){

        util.getWebElement(firstNameField).sendKeys(prop.getProperty("firstName"));
        util.getWebElement(lastNameField).sendKeys(prop.getProperty("lastName"));
        util.getWebElement(postalCodeField).sendKeys(prop.getProperty("postalCode"));

        util.getWebElement(continueButton).click();

        return new PurchaseOverviewPage();
    }



}
