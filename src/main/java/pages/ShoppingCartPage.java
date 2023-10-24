package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class ShoppingCartPage {

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        // elementUtils = new ElementUtils(driver);
    }
    WebDriver driver;
    ElementUtils elementUtils = new ElementUtils();
    @FindBy(xpath = "//*[@id='content']/h1")
    private WebElement textShoppingCart;

    @FindBy(xpath = "(//*[@class='text-left'])[2]")
    public WebElement productName;
    public void productName(){
        elementUtils.getTextFromElement(productName);
    }

    public WebElement textShoppingCart(){
        return textShoppingCart;
    }

    @FindBy(xpath = "//body/div[@id='checkout-cart']/div[1]")
    public WebElement alerText;
    public String  alerText(){
        return elementUtils.getTextFromElement(alerText);
    }

}


