package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.ConfigReader;

import java.time.Duration;

public class DriverFactory {

     static WebDriver driver;

    public static WebDriver initializeBrowser(String browserName) {

        // Read headless flag from system property or default to false
        boolean isHeadless = Boolean.parseBoolean(ConfigReader.getPropertyValue("headlessMode"));
        System.out.println("[DriverFactory] Browser: " + browserName + ", Headless: " + isHeadless);

        if (browserName.equals("chrome")) {
            // WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--window-size=1024,768");
            option.addArguments("--remote-allow-origins=*");
            option.addArguments("--no-sandbox");
            option.addArguments("--disable-dev-shm-usage");
            if (isHeadless) {
                option.addArguments("--headless=new"); // for Chrome v112+
                option.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());
            }
            driver = new ChromeDriver(option);
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {
            driver = new InternetExplorerDriver();
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equals("safari")) {
            driver = new SafariDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(1920,1080));
        //DriverFactory.getDriver().get(ConfigReader.getPropertyValue("url"));
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.EXPLICIT_WAIT_BASIC_TIME));
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
