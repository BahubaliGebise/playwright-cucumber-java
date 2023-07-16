package com.qa.swagLabs.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OverviewPage {
    final Page page;

    final Locator productName, finishBtn ;

    public OverviewPage(Page page) {
        this.page = page;
        this.productName = page.locator("//*[@id=\"item_4_title_link\"]/div");
        this.finishBtn = page.locator("//*[@id=\"finish\"]");

    }

    public void overviewDetails() {

        productName.waitFor();
        String textUI= productName.textContent();
        System.out.println("Added product name from UI:  "+textUI);
        finishBtn.click();

    }

}
