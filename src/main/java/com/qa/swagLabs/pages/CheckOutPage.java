package com.qa.swagLabs.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckOutPage {

    final Page page;
    final Locator checkoutBtn;

    public CheckOutPage(Page page) {
        this.page = page;
        this.checkoutBtn = page.locator("//*[@id=\"checkouttttt\"]");
    }

    // 3. page actions/methods:
    public String getCheckOutPageTitle() {
        return page.title();
    }

    public void clickCheckOutBtn() {
        checkoutBtn.waitFor();
        checkoutBtn.click();
    }
}
