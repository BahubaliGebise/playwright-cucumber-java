package com.qa.swagLabs.stepdefinitions;

import com.qa.swagLabs.factory.PlaywrightFactory;
import com.qa.swagLabs.pages.CustomerPage;
import com.qa.swagLabs.factory.PlaywrightFactory;
import com.qa.swagLabs.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.*;

import java.util.List;
public class CustomerDetailsPageStepDefs {
    final CustomerPage customerPage = new CustomerPage(PlaywrightFactory.getPage());


    @And("User provides customer details")
    public void userProvidesCustomerDetails(DataTable table) {

        String custPageTitle= customerPage.getCustomerPageTitle();
        System.out.println("Customer Page title"+custPageTitle);

        List<List<String>> data= table.asLists(String.class);

        for (List<String> datum : data) {
            String firstName = datum.get(0);
            String lastName = datum.get(1);
            String postalCode = datum.get(2);
            //Fill in your customer details
            customerPage.customerDetails(firstName,lastName,postalCode);

        }

    }


}
