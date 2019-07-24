package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", "html:target/cucumberHtmlReport",
                "html:target/cucumberHtmlReport",     //  for html result
                "pretty:target/cucumber.json",// for json result
                "json:target/cucumberxmlreport.html",
                 },
        tags = {"@EndToEnd"},
        features = "classpath:features",
        glue = {"com.test.stepdefs",

                // user step definitions package
        }
)
public class TestRunner {


}
