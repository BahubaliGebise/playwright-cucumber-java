package com.qa.swagLabs.hooks;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.qa.swagLabs.factory.PlaywrightFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;


public class Hooks {

    PlaywrightFactory pf;
    Page page;



    @Before("@UI")
    public void launchBrowser() {
        pf = new PlaywrightFactory();
        String browserName = System.getProperty("browserNm").toLowerCase();
        System.out.println(browserName);
        if (browserName.isEmpty()) {
            System.out.println("Pass valid browser name");
        }
        page = pf.initBrowser(browserName);

    }



    @After("@UI")
    public void takeScreenshot(Scenario scenario) {
        if(scenario.isFailed()){
            String screenshotName = scenario.getName();
            byte[] sourcePath = page.screenshot();
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
        PlaywrightFactory.getBrowserContext().tracing().
                stop(new Tracing.StopOptions().setPath(Paths.get("target/"+"trace.zip")));
        page.close();

    }




}
