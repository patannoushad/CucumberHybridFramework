package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	WebDriver driver;
	ElementUtils elementUtils = new ElementUtils() ;

	@FindBy(xpath="//span[text()='My Account']")
	public WebElement myAccountDropMenu;
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccountDropMenu);
	//	elementUtils.clickOnElement(loginOption);
	}
	
	@FindBy(linkText="Login")
	public WebElement loginOption;
	public LoginPage selectLoginOption() {
		elementUtils.clickOnElement(loginOption);
		return new LoginPage(driver);
	}
	
	@FindBy(linkText="Register")
	public WebElement registerOption;
	public LoginPage selectRegisterOption(){
		elementUtils.clickOnElement(registerOption);
		return new LoginPage(driver);
	}
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	public void enterProductIntoSearchBox(String productText) {
		elementUtils.typeTextIntoElement(searchBoxField,productText);
	}
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	public SearchResultsPage clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton);
		return new SearchResultsPage(driver);
	}

}
