package tests;

import base.Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class T002_PurchaseTests extends Base {

    @Test(description = "Product purchase test.")
    @Description("Select and confirm product purchase.")
    @Severity(SeverityLevel.CRITICAL)
    public void testProductPurchase(){

        ProductsPage productsPage = new ProductsPage();
        productsPage.addProductsToCart();
        System.out.println("[-] Selecting and adding products to Cart.");

        CartPage cartPage = productsPage.goToCartPage();

        Assert.assertTrue(cartPage.getPageHeader().contains("Your Cart"));
        System.out.println("[-] Landed on the CartPage after adding products to Cart.");

        productsPage = cartPage.continueShopping();

        Assert.assertTrue(productsPage.getPageHeader().contains("Products"));
        System.out.println("[-] Back to ProductsPage to remove item from Cart.");

        productsPage.removeProduct();
        System.out.println("[-] Removed product to maintain the budget.");

        cartPage = productsPage.goToCartPage();
        System.out.println("[-] Landed again in CartPage after removing the product.");

        PurchaseInfoPage purchaseInfoPage = cartPage.checkoutProduct();

        Assert.assertTrue(purchaseInfoPage.getPageHeader().contains("Checkout"));
        System.out.println("[-] Landed in PurchaseInfoPage.");

        System.out.println("[+] Filling in purchase details...");
        PurchaseOverviewPage purchaseOverviewPage = purchaseInfoPage.fillPurchaseInfoAndProceed();

        Assert.assertTrue(purchaseOverviewPage.getPageHeader().contains("Overview"));
        System.out.println("[-] Landed in PurchaseOverviewPage.");

        CompletePage completePage = purchaseOverviewPage.finishPurchase();

        Assert.assertTrue(completePage.getOrderConfirmationText().contains("Thank you for your order!"));
        System.out.println("[-] Order confirmed. Heading back to HomePage/ProductsPage.");
        productsPage = completePage.goBackHome();
    }
}
