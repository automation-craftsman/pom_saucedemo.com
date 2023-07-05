package pages;

import base.Base;
import org.openqa.selenium.By;
import support.Utilities;

public class CartPage extends Base {

    private By checkoutButton = By.xpath("//button[@id='checkout']");
    private By continueShoppingButton = By.xpath("//button[@id='continue-shopping']");

    private By pageHeader = By.xpath("//span[contains(text(),'Your Cart')]");

    Utilities util = new Utilities();

    public String getPageHeader(){
        return util.getWebElement(pageHeader).getText();
    }

    public ProductsPage continueShopping(){

        util.getWebElement(continueShoppingButton).click();

        return new ProductsPage();
    }

    public PurchaseInfoPage checkoutProduct(){

        util.getWebElement(checkoutButton).click();

        return new PurchaseInfoPage();
    }
}
