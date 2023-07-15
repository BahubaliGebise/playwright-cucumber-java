package com.qa.swagLabs.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.qa.swagLabs.utils.ConfigReader;



public class HomePage {


    final Page page;

    // 1. Locators
    private Locator userId, password, loginBtn, userNames, logoutLink, productMenu;

    // 2. page constructor:
    public HomePage(Page page) {
        this.page = page;
        this.userId = page.locator("//input[@id='user-name']");
        this.password = page.locator("//input[@id='password']");
        this.loginBtn = page.locator("//input[@id='login-button']");
        this.userNames = page.locator("//*[@id='login_credentials']/h4");
        this.logoutLink= page.locator("//a[@id='logout_sidebar_link']");
        this.productMenu = page.locator("//button[@id='react-burger-menu-btn']");
    }

    public void navigateToURL(){

        this.page.navigate(ConfigReader.getProperty("url"));
    }
    // 3. page actions/methods:
    public String getHomePageTitle() {
        System.out.println(page.title());
        return page.title();
    }

    public String getHomePageURL() {

        return page.url();
    }

    public void doLogin(String appUserName, String appPassword) {
        System.out.println("Swag Labs: " + appUserName + ":" + appPassword);
        userId.fill(appUserName);
        password.fill(appPassword);

    }

    public ProductPage navigateToProductPage() {
        loginBtn.waitFor();
        loginBtn.click();
        return new ProductPage(page);
    }

}
