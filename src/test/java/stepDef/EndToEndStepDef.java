package stepDef;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;
import pages.ShoppingCartPage;
public class EndToEndStepDef {

    WebDriver driver;
    AccountPage accountPage=new AccountPage(DriverFactory.getDriver());
    @Given("User opens the Applications")
    public void user_opens_the_application() {
        driver = DriverFactory.getDriver();
    }
    @When("User Add Product to Cart")
    public void User_Add_Product_to_Cart()  {
        accountPage.dropdownComponent();
        accountPage.selectMonitor();
    }

    @Then("User should Verify Total no of Products")
    public void User_should_Verify_Total_no_of_Products(){
        Assert.assertTrue(accountPage.moniterName().contains("Samsung SyncMaster 941BW"));
    }
    @When("User Add MacBook and IPhone to Cart")
    public void User_Add_MacBook_and_IPhone_to_Cart(){
        AccountPage accountPage=new AccountPage(driver);
        accountPage.MacBookAddtoCart();
        accountPage.iPhoneAddtoCart();
        accountPage.cartButton();
        accountPage.viewCartLink();
    }
    @And("User Selected View Cart")
    public void User_Selected_View_Cart(){
        AccountPage accountPage=new AccountPage(DriverFactory.getDriver());
        accountPage.cartButton();
        accountPage.viewCartLink();
    }
    ShoppingCartPage shoppingCartPage=new ShoppingCartPage(DriverFactory.getDriver());
    @Then("User should Verify Product Name")
    public void User_should_Verify_Product_Name(){
        Assert.assertTrue(shoppingCartPage.alerText().contains("Products marked with *** are not available in the desired quantity or not in stock!"));
    }
}


