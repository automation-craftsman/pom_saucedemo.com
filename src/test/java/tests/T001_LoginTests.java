package tests;

import base.Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import support.ExcelUtilities;

import java.io.IOException;

public class T001_LoginTests extends Base {

    public LoginPage loginPage;
    public ProductsPage productsPage;
    String filePath = ".\\src\\test\\resources\\login_data.xlsx";
    ExcelUtilities xl = new ExcelUtilities(filePath);

    @Test(dataProvider = "Login_Data", description = "Test different login credentials.")
    @Description("Test login for both valid and invalid username & password combinations.")
    @Severity(SeverityLevel.BLOCKER)
    public void testLoginCredentials(String userName, String userPassword) {
        loginPage = new LoginPage();

        productsPage = loginPage.loginUser(userName, userPassword);

        String actualPageHeader;

        try {
            actualPageHeader = productsPage.getPageHeader();
        } catch (Exception e) {
            actualPageHeader = "";
        }

        String expectedPageHeader = "Products";

        if (actualPageHeader.contains(expectedPageHeader)){
            productsPage.logoutUser();
            System.out.println("[-] Login successful with Username: " + userName + " & Password: " + userPassword);
        }
        else {
            System.out.println("[!] Login denied with Username: " + userName + " & Password: " + userPassword);
        }

    }

    @Test(description = "Login Test")
    @Description("Test with valid login credentials only.")
    @Severity(SeverityLevel.BLOCKER)
    public void testValidLoginCredentials(){
        loginPage = new LoginPage();
        productsPage = loginPage.loginUser(prop.getProperty("userName"), prop.getProperty("userPassword"));

        Assert.assertTrue(productsPage.getPageHeader().contains("Products"));

        System.out.println("[-] User logged in with Username: " + prop.getProperty("userName") +
                " & Password: " +prop.getProperty("userPassword") );
    }

    @DataProvider(name = "Login_Data")
    private Object[][] getLoginData() throws IOException {

        int rowCount = xl.getRowCount("Login_Details");
        int columnCount = xl.getColumnCount("Login_Details");

        Object userData[][] = new Object[rowCount][columnCount];

        for (int r=1; r<=rowCount; r++){
            for (int c=0; c<columnCount; c++){

                userData[r-1][c] = xl.getCellData("Login_Details", r, c);
            }
        }

        return userData;
    }
}
