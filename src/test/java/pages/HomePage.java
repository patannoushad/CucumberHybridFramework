package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import utils.ElementUtils;

import java.time.Duration;

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

	public void keys(){
		elementUtils.clickOnElement(searchButton);
		WebElement keyElement =driver.findElement(By.xpath("abd"));
		WebElement targetss =driver.findElement(By.id("abd"));
		Actions actions=new Actions(driver);

		actions.dragAndDrop(keyElement,targetss).perform();
	}
	public void action(){
		WebElement source = driver.findElement(By.id("source"));
		WebElement target = driver.findElement(By.id("target"));

		// Create an Actions object
		Actions actions = new Actions(driver);

		// Perform drag and drop
		actions.dragAndDrop(source, target).perform();
		actions.sendKeys(Keys.ADD);


	}

}
