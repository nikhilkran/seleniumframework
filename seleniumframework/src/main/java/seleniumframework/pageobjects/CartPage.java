 package seleniumframework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumframework.abstractcomponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	public CartPage(WebDriver driver){

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
//	List<WebElement> cartProduct = driver.findElements(By.cssSelector("div.cart"));
	@FindBy(css = "div.cart")
	List<WebElement>cartItems;
//	driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
	@FindBy(xpath = "(//button[@class='btn btn-custom'])[3]")
	WebElement product;

	public CheckoutPage clickCart() throws InterruptedException {
		Thread.sleep(2000);
		product.click();
		return new CheckoutPage(driver);  
		
	}

	
	public boolean cartItems(String productname) throws InterruptedException {
	boolean result = cartItems.stream().anyMatch(cproduct->cproduct.findElement(By.cssSelector("div.cart li h3")).getText().equalsIgnoreCase(productname));
	System.out.println(result);
	return result;
	
	}
	
}	
