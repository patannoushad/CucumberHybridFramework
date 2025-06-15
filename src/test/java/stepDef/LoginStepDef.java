package stepDef;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ElementUtils;
import utils.ExcelReader;

import java.util.List;
import java.util.Map;

public class LoginStepDef {

        WebDriver driver = DriverFactory.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        ElementUtils elementUtils = new ElementUtils() ;
        HomePage homePage= new HomePage(driver);


//        private CommonUtils commonUtils;

        @Given("^User navigate to login page$")
        public void user_navigate_to_login_page() {

//            driver = DriverFactory.getDriver();
//		HomePage homePage = new HomePage(DriverFactory.getDriver());
//		homePage.clickOnMyAccount();
//		loginPage = homePage.selectLoginOption();
        }
        @When("User enters valid email {string} into the email field")
        public void User_enters_valid_email_into_email_the_field(String emailText) {
            homePage.clickOnMyAccount();
            homePage.selectLoginOption();
            loginPage.enterEmailAddress(emailText);
        }
        @And("^User enters valid password (.+) into the password field$")
        public void user_enters_valid_password_into_the_password_field(String passwordText) {
            loginPage.enterPassword(passwordText);
        }
        @And("User clicks on Login button on page")
        public void user_clicks_on_login_button_on_page() {
            // login.clickOnLoginButton();
            loginPage.getLoginText(ConfigReader.getPropertyValue("logintrxt"));
        }

        @Then("User should get successfully loggedin")
        public void user_should_get_successfully_loggedin() {
            	Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
        }

        @When("^User gives (.*) in field$")
        public void User_gives_Condition_in_field(String val) {

            HomePage homePage = new HomePage(DriverFactory.getDriver());
            homePage.clickOnMyAccount();
            homePage.selectLoginOption();
            LoginPage loginP = new LoginPage(DriverFactory.getDriver());
            //InvalidEmail
            if(val.equals("invalidEmail") ){
                loginP.enterEmailAddress(ConfigReader.getPropertyValue("invalidEmails"));
                loginP.enterPassword(ConfigReader.getPropertyValue("validPswds"));
            }
            //InvalidPassword
            else if (val.equals("invalidPassword")) {
                loginP.enterEmailAddress(ConfigReader.getPropertyValue("validEmails"));
                loginP.enterPassword(ConfigReader.getPropertyValue("invalidPswds"));
            }
            //emptyEmail
            else if (val.equals("emptyEmail")) {
                loginP.enterPassword(ConfigReader.getPropertyValue("validPswds"));
            }
            //emptyPassword
            else if (val.equals("emptyPassword")) {
                loginP.enterEmailAddress(ConfigReader.getPropertyValue("validEmails"));
            }
            //emptyCredential
            else if (val.equals("emptyCredential")) {
//                loginPage.enterEmailAddress(" ");
//                loginPage.enterPassword(" ");
            }
        }
        @Then("^User should get a warning message about credentials mismatch (.*)$")
        public void user_should_get_a_warning_message_about_credentials_mismatch(String val) {
            LoginPage loginP = new LoginPage(DriverFactory.getDriver());

            //InvalidEmail
            if(val.equals("errorMsg") ) {
                Assert.assertTrue(loginP.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
            }else if (val.equals("invalidEmail")){
                Assert.assertTrue(loginP.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
            }
            //InvalidPassword
            else if (val.equals("invalidPassword")) {
                Assert.assertTrue(loginP.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
            }
            //emptyEmail
            else if (val.equals("emptyEmail")) {
                Assert.assertTrue(loginP.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
            }
            //emptyPassword
            else if (val.equals("emptyPassword")) {
                Assert.assertTrue(loginP.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
            }
            //emptyCredential
            else if (val.equals("emptyCredential")) {
                Assert.assertTrue(loginP.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
            }
            else  {
                Assert.assertTrue(loginP.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
            }
        }
}
