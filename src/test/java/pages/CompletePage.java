package pages;

import base.Base;
import org.openqa.selenium.By;
import support.Utilities;

public class CompletePage extends Base {

    private By backToHomeButton = By.xpath("//button[@id='back-to-products']");
    private By orderConfirmationText = By.xpath("//h2[@class='complete-header']");

    Utilities util = new Utilities();

    public String getOrderConfirmationText(){

        return util.getWebElement(orderConfirmationText).getText();
    }

    public ProductsPage goBackHome(){

        util.getWebElement(backToHomeButton).click();

        return new ProductsPage();
    }
}
