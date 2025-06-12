package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

     static WebDriver driver;

    public static WebDriver initializeBrowser(String browserName) {

        if (browserName.equals("chrome")) {
            // WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
            option.addArguments("--no-sandbox");
            option.addArguments("--disable-dev-shm-usage");
            option.addArguments("--headless=new");  // optional if you're running in CI
            option.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());
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
        driver.manage().window().maximize();
        //DriverFactory.getDriver().get(ConfigReader.getPropertyValue("url"));
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.EXPLICIT_WAIT_BASIC_TIME));
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
