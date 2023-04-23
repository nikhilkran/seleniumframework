package seleniumframework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumframework.abstractcomponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	
	WebDriver driver;
	public CheckoutPage(WebDriver driver){

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
//	driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
	@FindBy(xpath = "(//button[@class='btn btn-primary'])[3]")
	WebElement clickCheckout;
//	driver.findElement(By.xpath("(//input[@class='input txt text-validated'])[2]")).sendKeys("ind");
	@FindBy(xpath = "(//input[@class='input txt text-validated'])[2]")
	WebElement selectCountry;
//	List<WebElement> autoSuggestions = driver.findElements(By.xpath("//button[contains(@class,'list-group-item ng-star-inserted')]"));
	@FindBy(xpath = "//button[contains(@class,'list-group-item ng-star-inserted')]")
	List<WebElement> autoSuggestion;
//	WebElement e =driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")) ;
	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement placeOrder;
	
	public void cCheckout() throws InterruptedException {
		Thread.sleep(2000);
		clickCheckout.click();
	}
	
	public void sCountry() {
		selectCountry.sendKeys("ind");
	}
	
	
	public void aSuggestion() throws InterruptedException {
		Thread.sleep(2000);
		for(WebElement value: autoSuggestion) {
		if(value.getText().equalsIgnoreCase("india")) {
			value.click();
			break;
		}
     }
	}
	
	public void pOrder(JavascriptExecutor js ) throws InterruptedException {
		int x = placeOrder.getLocation().y;
	    js.executeScript("window.scrollTo(0,"+x+")");
	    Thread.sleep(2000);
	    placeOrder.click();
		


		
	}
}
