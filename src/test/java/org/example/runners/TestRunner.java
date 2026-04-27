package org.example.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepDefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-html-report.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml"
        },
        monochrome = true,
        tags = "@smoke or @registration or @signin or @signout"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
