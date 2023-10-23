package stepdefinition;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AccountSuccessPage;
import pages.HomePage;
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
            //  registerPage.enterRegestrationdetails();
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


    }


