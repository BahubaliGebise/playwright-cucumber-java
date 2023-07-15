package com.qa.swagLabs.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;
   // local thread copy - its java feature to work thread local
    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    public static Browser getBrowser() {
        return tlBrowser.get();
    }

    public static BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }

    public static Page getPage() {
        return tlPage.get();
    }

    public Page initBrowser(String browser) {

        tlPlaywright.set(Playwright.create());
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless"));

        switch (browser.toLowerCase()) {
            case "chromium":
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless)));
                break;
            case "firefox":
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless)));
                break;
            case "safari":
                tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless)));
                break;
            case "chrome":

                tlBrowser.set(
                        getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(isHeadless)));
                break;
            case "edge":
                tlBrowser.set(
                        getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(isHeadless)));

                break;
            default:
                System.out.println("please pass the right browser name......");
                break;
        }

        tlBrowserContext.set(getBrowser().newContext());
        tlPage.set(getBrowserContext().newPage());
        //To start tracing:
        getBrowserContext().tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
        return getPage();

    }




}
