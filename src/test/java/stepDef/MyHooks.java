package stepDef;

import factory.DriverFactory;
import io.cucumber.java.*;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.ReportManager;
import utils.TestCaseFilter;

public class MyHooks {

    @BeforeAll
    public static void beforeAll() {
        ReportManager.initReport();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        String scenarioName = scenario.getName().trim();
        ReportManager.startTest(scenarioName);

        boolean shouldRun = TestCaseFilter.shouldRunScenario(scenarioName);
        if (!shouldRun) {
            ReportManager.logSkip("Skipped based on Excel: " + scenarioName);
            Assume.assumeTrue(false); // Will stop scenario without marking as fail
        }

        DriverFactory.initializeBrowser(ConfigReader.getPropertyValue("browser"));
        DriverFactory.getDriver().get(ConfigReader.getPropertyValue("url"));
    }


//    @After
//    public void tearDown(Scenario scenario) {
//        if (DriverFactory.getDriver() != null) {
//            if (scenario.isFailed()) {
//                String scenarioName = scenario.getName().replaceAll(" ", "_");
//                byte[] srcScreenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
//                scenario.attach(srcScreenshot, "image/png", scenarioName);
//            }
//            DriverFactory.getDriver().quit();
//        }
//    }
@After
public void tearDown(Scenario scenario) {
    if (DriverFactory.getDriver() != null) {
        if (scenario.isFailed()) {
            ReportManager.logFail("Scenario failed: " + scenario.getName());
            String scenarioName = scenario.getName().replaceAll(" ", "_");
            byte[] srcScreenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcScreenshot, "image/png", scenarioName);
        } else {
            ReportManager.logPass("Scenario passed: " + scenario.getName());
        }
        DriverFactory.getDriver().quit();
    }
}
    @AfterAll
    public static void afterAll() {
        ReportManager.flushReport();
    }
}