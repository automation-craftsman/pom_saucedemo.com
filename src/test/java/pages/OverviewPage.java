package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.Utilities;

import java.util.List;

public class OverviewPage extends Base {

//    Yet to work on the purchase details. (getCartItems & getPurchaseDetails)

    private By cartList = By.xpath("//div[@class='cart_item_label']");
    private By paymentInfo = By.xpath("//div[normalize-space()='Payment Information']");
    private By shippingInfo = By.xpath("//div[normalize-space()='Shipping Information']");
    private By totalPrice = By.xpath("//div[@class=\"summary_info_label summary_total_label\"]");

    private By finishButton = By.xpath("//button[@id='finish']");


    Utilities util = new Utilities();

    private void getCartItems(){

        List<WebElement> itemList = util.getListOfWebElements(cartList);
    }

    public void getPurchaseDetails(){

        System.out.println("Items in the purchase list: ");

        System.out.println("Payment Information: " + util.getWebElement(paymentInfo).getText());
        System.out.println("Shipping Information: " + util.getWebElement(shippingInfo).getText());
        System.out.println("Total Price: " + util.getWebElement(totalPrice).getText());
    }

    public CompletePage finishPurchase(){

        util.getWebElement(finishButton).click();

        return new CompletePage();
    }
}
