package com.qa.swagLabs.stepdefinitions;

import com.qa.swagLabs.factory.PlaywrightFactory;
import com.qa.swagLabs.pages.CustomerPage;
import com.qa.swagLabs.pages.OverviewPage;
import io.cucumber.java.en.Then;

public class OverviewPageStepDefs {
    final OverviewPage OverviewPage = new OverviewPage(PlaywrightFactory.getPage());
    @Then("User verify over page details and confirmation")
    public void userVerifyOverPageDetailsAndConfirmation() {
        OverviewPage.overviewDetails();
    }
}
