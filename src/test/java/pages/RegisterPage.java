package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ElementUtils;
import utils.TestData;

import java.util.List;

public class RegisterPage {
	
	WebDriver driver;
	public ElementUtils elementUtils;
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		//elementUtils = new ElementUtils(driver);
	}


	@FindBy(id="input-firstname")
	public WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@name='confirm']")
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


	
	public AccountSuccessPage clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton);
		return new AccountSuccessPage(driver);
	}
	public void ContinueButton(){
		continueButton.click();
	}

	public void enterRegestrationdetails() {

		// Check if the firstName is not null or empty before sending keys
		if (TestData.get("firstname") != null && !TestData.get("firstname").isEmpty()) {
			firstNameField.sendKeys(TestData.get("firstname"));
		} else {
			System.out.println("Error: First name is null or empty.");
			// Handle the error or throw an exception as needed
		}

		// Check if the lastName is not null or empty before sending keys
		if (TestData.get("lastname") != null && !TestData.get("lastname").isEmpty()) {
			lastNameField.sendKeys(TestData.get("lastname"));
		} else {
			System.out.println("Warning: Last name is null or empty.");
			// Handle the situation based on your requirements
		}

//		firstNameField.sendKeys(TestData.get("firstname"));
//		lastNameField.sendKeys(TestData.get("lastname"));
		emailField.sendKeys(TestData.get("email"));
		telephoneField.sendKeys(TestData.get("telephone"));
		passwordField.sendKeys(TestData.get("password"));
		passwordConfirmField.sendKeys(TestData.get("pswdConfirm"));
		privacyPolicyOption.click();
		continueButton.click();
	}

	@FindBy(xpath = "//body/div[@id='account-register']/div[1]")
	public List<WebElement> errorMsg;
	public void verifyErrorMessage() {
		if (!errorMsg.isEmpty()) {
			for (WebElement ele : errorMsg) {
				String text = ele.getText();
				Assert.assertEquals(text,TestData.get("condition"));
			}
		} else {
			// Log or handle the case when errorMessages is empty
			System.out.println("Log or handle the case when errorMessages is empty");
		}

	}
}
