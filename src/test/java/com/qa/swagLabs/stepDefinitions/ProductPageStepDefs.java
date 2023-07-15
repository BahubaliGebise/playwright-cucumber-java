package com.qa.swagLabs.stepDefinitions;

import com.qa.swagLabs.factory.PlaywrightFactory;
import com.qa.swagLabs.pages.HomePage;
import com.qa.swagLabs.pages.ProductPage;
import com.qa.swagLabs.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class ProductPageStepDefs {

    final ProductPage productPage = new ProductPage(PlaywrightFactory.getPage());
    @Given("I am on Product Page")
    public void iAmOnProductPage() {
        Assert.assertTrue(productPage.isProductsHeaderVisible());
    }

    @When("I see Backpack product")
    public void iSeeBackpackProduct() {
        Assert.assertTrue(productPage.isBackpackProductVisible());
    }

    @Then("I add Backpack to Cart")
    public void iAddBackpackToCart() {
        productPage.selectProduct();
    }
}
