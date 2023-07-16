package com.qa.swagLabs.stepdefinitions;

import com.qa.swagLabs.factory.PlaywrightFactory;
import com.qa.swagLabs.pages.CheckOutPage;
import com.qa.swagLabs.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class ProductPageStepDefs {

    final ProductPage productPage = new ProductPage(PlaywrightFactory.getPage());

    final CheckOutPage checkOutPage = new CheckOutPage(PlaywrightFactory.getPage());

    @Given("I am on Product Page")
    public void iAmOnProductPage() {
        Assert.assertTrue(productPage.isProductsHeaderVisible());
    }

    @When("User see Backpack product")
    public void iSeeBackpackProduct() {
        Assert.assertTrue(productPage.isBackpackProductVisible());
    }

    @Then("User add Backpack to Cart")
    public void iAddBackpackToCart() {
        productPage.selectProduct();
    }

    @Then("User able to navigate to customer")
    public void userAbleToNavigateToCustomer() {
        String title = checkOutPage.getCheckOutPageTitle();
        System.out.println("checkout page title: "+title);

        checkOutPage.clickCheckOutBtn();
    }
}
