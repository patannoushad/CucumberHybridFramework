package stepdefinition;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;

public class MyHooks {
        @Before
        public void setup() {
            DriverFactory.initializeBrowser(ConfigReader.getPropertyValue("browser"));
            DriverFactory.getDriver().get(ConfigReader.getPropertyValue("url"));
        }
        @After
        public void tearDown(Scenario scenario) {
            String scenarioName = scenario.getName().replaceAll(" ", "_");
            if (scenario.isFailed()) {
                byte[] srcScreenshot = (byte[])((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(srcScreenshot, "image/png", scenarioName);
            }
        //    DriverFactory.getDriver().close();
        }
    }


