package tests;

import base.Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class T003_LogoutTests extends Base {

    @Test(description = "Logging out user.")
    @Description("Logging out after successful purchase.")
    @Severity(SeverityLevel.CRITICAL)
    public void logoutUser(){
        ProductsPage productsPage = new ProductsPage();

        LoginPage loginPage = productsPage.logoutUser();

        Assert.assertTrue(loginPage.getPageHeader().contains("Swag Labs"));
        System.out.println("[-] User successfully logged out.");
    }

}
