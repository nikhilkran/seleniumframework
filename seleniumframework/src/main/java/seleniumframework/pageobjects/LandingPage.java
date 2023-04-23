package seleniumframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumframework.abstractcomponents.AbstractComponent;
//....................................................PageObject Pattern & FactoryImplementation........................................................
public class LandingPage extends AbstractComponent{
	
	WebDriver driver; // later when it got initialised then it will have that value in this container..
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//locators separately listed for individual page..
	
	@FindBy(xpath = "//input[@id='userEmail']") // initialize
	WebElement username; // declare
	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement passwordE;
	@FindBy(xpath = "//input[@id='login']")
	WebElement submit;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatalagaue loginApplication(String email,String password) {
		username.sendKeys(email);
		passwordE.sendKeys(password);
		submit.click();
		return new ProductCatalagaue(driver);
	}
}
