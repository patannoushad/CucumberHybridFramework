package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-email")
	public WebElement emailField;
	
	@FindBy(id="input-password")
	public WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
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
