package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        plugin = {
//                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,features = {"src/test/resources"}
        ,glue = {"stepDef"}
        ,snippets = CAMELCASE
        ,monochrome=false
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

