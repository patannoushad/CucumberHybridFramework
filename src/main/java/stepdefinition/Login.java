package stepdefinition;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

import java.util.Properties;

public class Login {

        WebDriver driver;
        private LoginPage loginPage;
//        private AccountPage accountPage;
//        private CommonUtils commonUtils;

        Properties prop = new Properties();

        @Given("^User navigate to login page$")
        public void user_navigate_to_login_page() {

            driver = DriverFactory.getDriver();
            AccountPage accountPage=new AccountPage(DriverFactory.getDriver());
            accountPage.dropdownComponent();
            accountPage.selectMonitor();
//		HomePage homePage = new HomePage(DriverFactory.getDriver());
//		homePage.clickOnMyAccount();
//		loginPage = homePage.selectLoginOption();

        }
        @When("User enters valid email {string} into the email field")
        public void User_enters_valid_email_into_email_the_field(String emailText) {
            HomePage homePage = new HomePage(DriverFactory.getDriver());
            homePage.clickOnMyAccount();
            loginPage = homePage.selectLoginOption();
            loginPage.enterEmailAddress(emailText);
        }
        @And("^User enters valid password (.+) into the password field$")
        public void user_enters_valid_password_into_the_password_field(String passwordText) {

            //loginPage.enterPassword(passwordText);
        }
        @And("User clicks on Login button on page")
        public void user_clicks_on_login_button_on_page() {

//		accountPage = loginPage.clickOnLoginButton();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }

        @Then("User should get successfully loggedin")
        public void user_should_get_successfully_loggedin() {

            //	Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
        }

        @When("User gives (.*) in field")
        public void User_gives_Condition_in_field(String val) {



            //InvalidEmail
            if(val.equals("invalidEmail") ){

                loginPage.enterEmailAddress(prop.getProperty("invalidEmail"));
                loginPage.enterPassword(prop.getProperty("validPswd"));
            }
            //InvalidPassword
            else if (val.equals("invalidPassword")) {
                loginPage.enterEmailAddress(prop.getProperty("validEmail"));
                loginPage.enterPassword(prop.getProperty("invalidPswd"));
            }
            //emptyEmail
            else if (val.equals("emptyEmail")) {
                loginPage.enterEmailAddress(" ");
                loginPage.enterPassword(prop.getProperty("invalidPswd"));
            }
            //emptyPassword
            else if (val.equals("emptyPassword")) {
                loginPage.enterEmailAddress(prop.getProperty("validEmail"));
                loginPage.enterPassword(" ");
            }
            //emptyCredential
            else if (val.equals("emptyCredential")) {
                loginPage.enterEmailAddress(" ");
                loginPage.enterPassword(" ");
            }
        }
        @Then("User should get a warning message about credentials mismatch")
        public void user_should_get_a_warning_message_about_credentials_mismatch() {

            Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));

        }
    }


//-------------------------------------------------------------------->
/*
WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;

	@Given("^User navigates to login page$")
	public void user_navigates_to_login_page() {

		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();
	}
	@When("^User enters valid email address into email field$")
	public void User_enters_valid_email_address_into_email_field() {

		loginPage.enterEmailAddress(ConfigReader.getPropertyValue("validEmail"));
	}
	@And("^User enters valid password into password field$")
	public void user_enters_valid_password_into_password_field() throws InterruptedException {

		loginPage.enterPassword(ConfigReader.getPropertyValue("validPswd"));
		Thread.sleep(5000);
	}
	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button() {

		accountPage = loginPage.clickOnLoginButton();
	}
	@Then("^User should get successfully logged in$")
	public void user_should_get_successfully_logged_in() {

		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}
	@When("^User enters invalid email address into email field$")
	public void user_enters_invalid_email_address_into_email_field()  {
	//		commonUtils = new CommonUtils();
	//	loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());

		loginPage.enterEmailAddress(ConfigReader.getPropertyValue("invalidEmail"));
	}
	@And("^User enters invalid password into password field$")
	public void user_enters_invalid_password_into_password_field() {

		loginPage.enterPassword(ConfigReader.getPropertyValue("invalidPswd"));
	}
	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {

		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}
	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {

		loginPage.enterEmailAddress("");
	}
	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {

		loginPage.enterPassword("");
	}
}
package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


import java.time.Duration;
import java.util.Properties;


public class LoginNoushad {



------------------------------------------------------------------>
Feature: LoginNoushad functionalitys


Scenario: Login with valid credentials
Given User navigates to login page
When User enters valid email address into email field
And User enters valid password into password field
And User clicks on Login button
Then User should get successfully logged in

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address into email field
And User enters invalid password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address into email field
And User enters valid password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentails
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

 */

