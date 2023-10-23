package stepdefinition;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;
import pages.ShoppingCartPage;
public class EndtoEnd {

    WebDriver driver;
    @Given("User opens the Applications")
    public void user_opens_the_application() {
        driver = DriverFactory.getDriver();
    }

    @When("User Add Product to Cart")
    public void User_Add_Product_to_Cart()  {
        AccountPage accountPage=new AccountPage(DriverFactory.getDriver());
        accountPage.dropdownComponent();
        accountPage.selectMonitor();
    }

    @Then("User should Verify Total Amount")
    public void User_should_Verify_Total_Amount(){

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

//        shoppingCartPage.productName();
    }
}


