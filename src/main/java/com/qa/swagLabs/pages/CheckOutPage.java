package com.qa.swagLabs.pages;

import com.microsoft.playwright.Page;

public class CheckOutPage {

    final Page page;

    public CheckOutPage(Page page) {
        this.page = page;
    }

    // 3. page actions/methods:
    public String getCheckOutPageTitle() {
        return page.title();
    }

//    public boolean isProductNamesListExist() {
//        return page.isVisible(backPacklink);
//    }
}
