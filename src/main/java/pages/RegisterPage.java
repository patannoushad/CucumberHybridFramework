package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ElementUtils;
import utils.TestData;

import java.util.List;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		//elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement YesNewsletterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWaring;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	@FindBy(xpath = "//div[@class='text-danger']")
	public List<WebElement> errorMessages;
	
	public AccountSuccessPage clickOnContinueButton() {
		
		elementUtils.clickOnElement(continueButton);
		return new AccountSuccessPage(driver);
		
	}
	public void ContinueButton(){
		continueButton.click();
	}

	public void enterRegestrationdetails() {
		firstNameField.sendKeys(TestData.get("firstName"));
		lastNameField.sendKeys(TestData.get("lastname"));
		emailField.sendKeys(TestData.get("email"));
		telephoneField.sendKeys(TestData.get("telephone"));
		passwordField.sendKeys(TestData.get("password"));
		passwordConfirmField.sendKeys(TestData.get("password confirm"));
	}


	public void verifyErrorMessage() {
		for (WebElement ele : errorMessages) {
			Assert.assertEquals(ele.getText(),TestData.get("Condition"));
		}

	}

}
