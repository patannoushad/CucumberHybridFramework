package stepdefinition;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.CommonUtils;
import utils.ElementUtils;
import utils.TestData;

import java.io.FileNotFoundException;

public class Register {

        WebDriver driver= DriverFactory.getDriver();
        private ElementUtils elementUtils;

        RegisterPage registerPage=new RegisterPage(driver);
        HomePage homePage ;
        private AccountSuccessPage accountSuccessPage;
        private CommonUtils commonUtils;

        @Given("User navigates to Register Account page")
        public void user_navigates_to_register_account_page() {
            homePage.clickOnMyAccount();
        }

        @Given("User navigates to Register Account page {string}")
        public void user_navigates_to_register_account_page(String testCaseID) throws FileNotFoundException {
            System.out.println("Driver ----------" +driver);
            TestData.readTestData(testCaseID);
            System.out.println("TestData -------"+testCaseID);
              registerPage.enterRegestrationdetails();
        }

        @When("User dont enter detail into fields")
        public void user_dont_enter_detail_into_fields(DataTable dataTable) {

            //  registerPage.enterRegestrationdetails();
        }

        @Then("User should get proper warning message")
        public void user_should_get_proper_warning_message() {
            //registerPage.verifyErrorMessage();
        }

        @Then("User account should get created successfully")
        public void user_account_should_get_created_successfully() {

            //Assert.assertEquals("Your Account Has Been Created!",accountSuccessPage.getPageHeading());
        }

    @When("^User enter (.*) in field$")
    public void User_enter_Condition_in_field(String testcaseID) throws FileNotFoundException {
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        homePage.clickOnMyAccount();
        homePage.selectRegisterOption();
        TestData.readTestData(testcaseID);
        registerPage.enterRegestrationdetails();
    }
    @Then("^User should get a warning message about credential mismatch (.*)$")
    public void user_should_get_a_warning_message_about_credential_mismatch(String testcaseID) {
        registerPage.verifyErrorMessage();

    }
}



