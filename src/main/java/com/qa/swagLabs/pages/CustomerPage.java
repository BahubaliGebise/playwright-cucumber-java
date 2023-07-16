package com.qa.swagLabs.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.swagLabs.factory.PlaywrightFactory;

public class CustomerPage {

    final Page page;

    final Locator firstName, lastName, postalCode, continueBtn;

    public CustomerPage(Page page) {
        this.page = page;
        this.firstName = page.locator("//*[@id=\"first-name\"]");
        this.lastName = page.locator("//*[@id=\"last-name\"]");
        this.postalCode = page.locator("//*[@id=\"postal-code\"]");
        this.continueBtn = page.locator("//*[@id=\"continue\"]");
    }

    public String getCustomerPageTitle() {
        return page.title();
    }

    public void customerDetails(String fName, String lName, String postCodes) {

        firstName.waitFor();
        firstName.fill(fName);
        lastName.fill(lName);
        postalCode.fill(postCodes);
        continueBtn.click();
    }

}