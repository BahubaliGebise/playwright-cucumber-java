package com.qa.swagLabs.testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features",
        glue= {"com/qa/swagLabs"},
        plugin={"json:target/cucumber-report/cucumber.json","me.jvt.cucumber.report.PrettyReports:target","pretty"},
        monochrome = true
)

public class CucumberTestRunner {


}
