package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features",
//        features = "FeatureFiles",
        glue = "stepdefinition",
        tags = "@register",
        plugin = {"pretty","html:target/CucumberReports/CucumberReport.html"},
        publish = true
)
public class TestRunner {
}
