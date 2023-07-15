package com.qa.swagLabs.testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.io.File;
import java.lang.module.Configuration;
import java.util.List;


@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features",
        glue= {"com/qa/swagLabs"},
        plugin={"me.jvt.cucumber.report.PrettyReports:target","pretty"},
        monochrome = true
)

public class CucumberTestRunner {


}
