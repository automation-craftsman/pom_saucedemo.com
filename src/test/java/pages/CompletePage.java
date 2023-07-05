package pages;

import base.Base;
import org.openqa.selenium.By;
import support.Utilities;

public class CompletePage extends Base {

    private By backToHomeButton = By.xpath("//button[@id='back-to-products']");

    Utilities util = new Utilities();

    public ProductsPage goBackHome(){

        util.getWebElement(backToHomeButton).click();

        return new ProductsPage();
    }
}
