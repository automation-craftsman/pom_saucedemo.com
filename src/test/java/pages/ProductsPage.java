package pages;

import base.Base;
import org.openqa.selenium.By;
import support.Utilities;

public class ProductsPage extends Base {

    private By productAddToCartButton = By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
    private By cartButton = By.xpath("//a[@class='shopping_cart_link']");
    private By menuButton = By.xpath("//button[@id='react-burger-menu-btn']");
    private By logoutButton = By.xpath("//a[@id='logout_sidebar_link']");

    Utilities util = new Utilities();

    public void addProductToCart(){

        if (util.getWebElement(productAddToCartButton).isDisplayed()){

            util.getWebElement(productAddToCartButton).click();
        }
        else {

            util.scrollToElement(productAddToCartButton);
            util.getWebElement(productAddToCartButton).click();
            util.scrollPageTo("top");
        }

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
