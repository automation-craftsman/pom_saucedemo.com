package pages;

import base.Base;
import org.openqa.selenium.By;
import support.Utilities;

public class CartPage extends Base {

    private By checkoutButton = By.xpath("//button[@id='checkout']");

    Utilities util = new Utilities();

    public PurchaseInfoPage checkoutProduct(){

        util.getWebElement(checkoutButton).click();

        return new PurchaseInfoPage();
    }
}
