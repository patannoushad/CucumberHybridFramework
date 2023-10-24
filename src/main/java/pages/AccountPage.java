package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class AccountPage {
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	WebDriver driver;
	ElementUtils elementUtils = new ElementUtils() ;

	@FindBy(linkText="Edit your account information")
	public WebElement editYourAccountInformationOption;

	@FindBy(xpath = "//a[text()=\"Components\"]")
	public static WebElement dropdownComponent;
	public void dropdownComponent() {
		//elementUtils.clickOnElement(dropdownComponent,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.clickOnElement(dropdownComponent);
		//elementUtils.clickOnElement(selectMonitor);
	}
	@FindBy(xpath = "//a[text()=\"Monitors (2)\"]")
	public WebElement selectMonitor;
	public void selectMonitor(){
		elementUtils.clickOnElement(selectMonitor);
	}

	@FindBy(xpath = "((//div[@class='button-group'])[1]/button[@type='button'])[1]")
	public WebElement macBookAddtoCart;
	public void MacBookAddtoCart(){
		elementUtils.clickOnElement(macBookAddtoCart);
	}

	@FindBy(xpath = "((//div[@class='button-group'])[2]/button[@type='button'])[1]")
	public WebElement iPhoneAddtoCart;
	public void iPhoneAddtoCart(){
		elementUtils.clickOnElement(iPhoneAddtoCart);
	}

	@FindBy(xpath = "//div[@id='cart']/button")
	public WebElement cartButton;
	public void cartButton(){
		elementUtils.clickOnElement(cartButton);
	}

	@FindBy(xpath = "(//*[@class='text-right'])[13]/a[1]")
	public WebElement viewCartLink;
	public void viewCartLink(){
		elementUtils.clickOnElement(viewCartLink);
	}
	public boolean displayStatusOfEditYourAccountInformationOption() {
		return elementUtils.displayStatusOfElement(editYourAccountInformationOption);
	}


}
