package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;


public class LoginPage {
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	WebDriver driver;
	ElementUtils elementUtils = new ElementUtils() ;

	@FindBy(xpath = "//input[@id=\"input-email\"]")
	public WebElement emailField;
	
	@FindBy(id="input-password")
	public WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;


	public void getLoginText(String val) {
		String dynamicXPath = String.format("//input[@value='%s']",val);
		driver.findElement(By.xpath(dynamicXPath)).click();
	}


	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	public WebElement warningMessage;
	
	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText);
	}
	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText);
	}
	
	public AccountPage clickOnLoginButton() {
		elementUtils.clickOnElement(loginButton);
		return new AccountPage(driver);
	}
	
	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMessage);
	}

}
