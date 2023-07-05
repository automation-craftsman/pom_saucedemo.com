package pages;

import base.Base;
import org.openqa.selenium.By;
import support.Utilities;

public class LoginPage extends Base {

    private By userNameField = By.xpath("//input[@id='user-name']");
    private By passwordFiled = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='login-button']");

    Utilities util = new Utilities();

    public ProductsPage loginUser(String userName, String userPassword){

        util.getWebElement(userNameField).sendKeys(userName);
        util.getWebElement(passwordFiled).sendKeys(userPassword);

        util.getWebElement(loginButton).click();

        return new ProductsPage();
    }

}
