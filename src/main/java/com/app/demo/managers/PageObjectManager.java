package com.app.demo.managers;

import com.app.demo.pages.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productPage;
    private YourCarPage yourCarPage;
    private YourInformationPage yourInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;
    private static PageObjectManager pageObjectManager;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginPage() {
        return loginPage == null ? loginPage = new LoginPage(driver) : loginPage;
    }

    public ProductsPage productPage() {
        return productPage == null ? productPage = new ProductsPage(driver) : productPage;
    }

    public YourCarPage yourCarPage() {
        return yourCarPage == null ? yourCarPage = new YourCarPage(driver) : yourCarPage;
    }

    public YourInformationPage yourInformationPage() {
        return yourInformationPage == null ? yourInformationPage = new YourInformationPage(driver) : yourInformationPage;
    }

    public CheckoutOverviewPage checkoutOverviewPage() {
        return checkoutOverviewPage == null ? checkoutOverviewPage = new CheckoutOverviewPage(driver) : checkoutOverviewPage;
    }

    public CheckoutCompletePage checkoutCompletePage() {
        return checkoutCompletePage == null ? checkoutCompletePage = new CheckoutCompletePage(driver) : checkoutCompletePage;
    }
}
