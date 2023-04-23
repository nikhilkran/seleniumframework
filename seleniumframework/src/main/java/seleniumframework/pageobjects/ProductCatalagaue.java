package seleniumframework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumframework.abstractcomponents.AbstractComponent;

public class ProductCatalagaue extends AbstractComponent{
// ..............................now u  can access by calling from here...........................................
	WebDriver driver;
	public ProductCatalagaue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	By productBy = By.cssSelector(".mb-3"); // v.imp- since it is onlylocator not WebElement i,e driver hence cannot apply pagefactory..
	By addProduct = By.xpath("//button[@class='btn w-10 rounded']");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productBy);
		return products;
	}
	public WebElement getProductByName(String productname ) {
		WebElement addToCartProduct = getProductList().stream().filter(product->product.findElement(By.cssSelector("b" )).getText().equalsIgnoreCase(productname))
				.findFirst().orElse(null);
		return addToCartProduct;
	}
	
	public CartPage addProductToCart(String productName) {
		getProductByName(productName).findElement(addProduct).click(); //v.imp- since further we are confining hence cannot apply pagefactory..
	   return  new CartPage(driver);
	}
	
	
	
}
