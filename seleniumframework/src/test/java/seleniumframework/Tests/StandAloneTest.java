package seleniumframework.Tests;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumframework.TestComponents.BaseTest;
import seleniumframework.pageobjects.CartPage;
import seleniumframework.pageobjects.CheckoutPage;
import seleniumframework.pageobjects.LandingPage;
import seleniumframework.pageobjects.ProductCatalagaue;

public class StandAloneTest extends BaseTest{



	// ---------------------------------------------------driver executable set
	  // alternatively, we can add dependency of webdriver in pom.xml 
	// WebDriverManager.chromedriver().setup();
//	static {
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//	}

	@Test
	public void submitOrder() throws FileNotFoundException, IOException, InterruptedException {
		
		// invoke ChromeDriver
		
		    String productname = "zara coat 3";
	
			WebDriver driver  = initialiseDriver();

			JavascriptExecutor js = (JavascriptExecutor)driver; // used for scrolling..
			LandingPage  landing = new  LandingPage(driver);   // why we are creating object because nonstatic not allowed inside static..
			landing.goTo();
			ProductCatalagaue productCatalagaue = landing.loginApplication("nikhilrana1995@gmail.com","Nikhil#1705");
			List<WebElement> products = productCatalagaue.getProductList();
			CartPage cart  = productCatalagaue.addProductToCart(productname);
			CheckoutPage checkout = cart.clickCart();
			boolean result = cart.cartItems(productname);
			Assert.assertTrue(result);
			checkout.cCheckout();
			checkout.sCountry();
			checkout.aSuggestion();
		    checkout.pOrder(js);
		
		// imlpicitly wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// invoke url in driver

		
		//---------------------------------------automation scripts------------------------
//		LandingPage  landing = new  LandingPage(driver);   // why we are creating object because nonstatic not allowed inside static..
//		landing.goTo();
		 
//		driver.get("https://rahulshettyacademy.com/client");
//		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("nikhilrana1995@gmail.com");
//		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Nikhil#1705");
		
//		driver.findElement(By.xpath("//input[@id='login']")).click();
		
	
		
		
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//		System.out.println(products);
		// ----------------------------------------routinal approach---------------------------
//		for(WebElement ele : products) {
//			if(ele.findElement(By.xpath("//b[text()='zara coat 3']")).getText().equalsIgnoreCase("zara coat 3")) {
//				for(int i=1;i<=3;i++) {
//				ele.findElement(By.cssSelector(".btn.w-10.rounded")).click();
//				Thread.sleep(2000);
//				}
//				break;
//			}
//		}
		//-----------------------------------------------concept of JavaStream--------------------------
//		WebElement product1 = products.stream().filter(product->product.findElement(By.cssSelector("b" )).getText().equalsIgnoreCase(productname))
//		.findFirst().orElse(null);
		// mistake of equals ignore case since selenium matches with what present on screen.........................................
//		System.out.println(product1);
//      ..........................v.v.important- mow area have been confined to product1 only.......................................
		
		
//	     product1.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
		//......... make sure that session got visible and  loading black page has disaapear then only we go to addtocart page...............
//		WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated("not aable to detect locator in console---ask developer"));
//		Thread.sleep(2000);// or can use explicit wait..................
		
		
		
//		driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
		
//	if(driver.findElement(By.cssSelector("div.cart li h3")).getText().equalsIgnoreCase("zara coat 3")) {
//		System.out.println("element added is correct what displayed..");
//	}
	
//	List<WebElement> cartProduct = driver.findElements(By.cssSelector("div.cart"));
//	boolean result = cartProduct.stream().anyMatch(cproduct->cproduct.findElement(By.cssSelector("div.cart li h3")).getText().equalsIgnoreCase(productname));
		
 // ........................vimp - it will not go to pageobject model.......................................
		
	
		
//		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
	
		
//		driver.findElement(By.xpath("(//input[@class='input txt text-validated'])[2]")).sendKeys("ind");
	
//		List<WebElement> autoSuggestions = driver.findElements(By.xpath("//button[contains(@class,'list-group-item ng-star-inserted')]"));
//		for(WebElement value: autoSuggestions) {
//			if(value.getText().equalsIgnoreCase("india")) {
//				value.click();
//				break;
//			}
//	
//		}
 
//		WebElement e =driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")) ;
//		int x = e.getLocation().y;
//	    js.executeScript("window.scrollTo(0,"+x+")");
//	    Thread.sleep(2000);
//	    e.click();
//		
//
//
//		Thread.sleep(5000);
//		driver.close();
		

	}

}
