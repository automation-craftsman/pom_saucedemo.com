package pages;

import base.Base;
import org.openqa.selenium.By;
import support.Utilities;

public class ProductsPage extends Base {

    private By backPackAddToCartButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private By jacketAddToCartButton = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
    private By tShirtAddToCartButton = By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
    private By removeJacketButton = By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']");
    private By cartButton = By.xpath("//a[@class='shopping_cart_link']");
    private By menuButton = By.xpath("//button[@id='react-burger-menu-btn']");
    private By logoutButton = By.xpath("//a[@id='logout_sidebar_link']");

    private By PageHeader = By.xpath("//span[contains(text(),'Products')]");

    Utilities util = new Utilities();

    public String getPageHeader(){

        return util.getWebElement(PageHeader).getText();
    }

    public void addProductsToCart(){

        util.getWebElement(backPackAddToCartButton).click();
        util.getWebElement(jacketAddToCartButton).click();

        util.scrollPageTo("bottom");
        util.getWebElement(tShirtAddToCartButton).click();
        util.scrollPageTo("top");
    }

    public void removeProduct(){

        util.getWebElement(removeJacketButton).click();
    }

    public CartPage goToCartPage(){

        util.getWebElement(cartButton).click();

        return new CartPage();
    }

    public LoginPage logoutUser(){

        util.getWebElement(menuButton).click();

        util.waitToClick(logoutButton, 2);
        util.getWebElement(logoutButton).click();

        return new LoginPage();
    }
}
