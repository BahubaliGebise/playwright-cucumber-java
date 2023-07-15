package com.qa.swagLabs.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {

    final Page page;


    // 1. String Locators - OR
    final Locator backPackLink, addToCartBtn, shoppingCartBasketLink, checkoutBtn, productMenu, productsHeader;


    // 2. page constructor:
    public ProductPage(Page page) {
        this.page = page;
        this.backPackLink = page.locator("//div[normalize-space()='Sauce Labs Backpack']");
        this.addToCartBtn = page.locator("//button[@id='add-to-cart-sauce-labs-backpack']");
        this.shoppingCartBasketLink = page.locator("//a[@class='shopping_cart_link']");
        this.checkoutBtn = page.locator("//button[@id='checkout']");
        this.productMenu = page.locator("//button[@id='react-burger-menu-btn']");
        this.productsHeader = page.locator("//span[text()='Products']");
    }

    // 3. page actions/methods:

    public String getProductPageTitle() {
        return page.title();
    }

    public boolean isProductsHeaderVisible(){
        productsHeader.waitFor();
        return productsHeader.isVisible();
    }

    public boolean isBackpackProductVisible() {
        return backPackLink.isVisible();
    }


    public void selectProduct() {


        addToCartBtn.click();
        shoppingCartBasketLink.waitFor();
        shoppingCartBasketLink.click();


    }

    public CheckOutPage navigateToCheckOut() {
        checkoutBtn.waitFor();
        checkoutBtn.click();
        return new CheckOutPage(page);
    }
}
