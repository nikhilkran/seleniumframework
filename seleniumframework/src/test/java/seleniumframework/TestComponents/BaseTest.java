package seleniumframework.TestComponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;



//import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest{
	
	WebDriver driver;

	public WebDriver initialiseDriver() throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		
		prop.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\seleniumframework\\properties\\GlobalData.properties"));
	    String browserName = prop.getProperty("browser");
	    if(browserName.equalsIgnoreCase("chrome")) {
//	    	WebDriverManager.chromedriver().setup();
	    	
//	    	or driver = WebDriverManager.chromedriver().create();	for both line
	    	System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	    	driver = new ChromeDriver();
	    	
	    }else if(browserName.equalsIgnoreCase("firefox")) {
//	    	System.setProperty("webdriver.gecko.driver", "./driver.firefox.exe");
	    	driver = new FirefoxDriver();
	    }else if ((browserName.equalsIgnoreCase("edge"))){
//	    	System.setProperty("webdriver.edge.driver", "./driver.edge.exe");
	    	driver = new EdgeDriver();
	    }
	    driver.manage().window().maximize();
	    return driver;
	}
	
	public String getScreenshot(String testcasename,WebDriver driver) throws IOException {
//		Date d = new Date();
//		String reportsFolder=d.toString().replaceAll(":", "-");
//		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"//nikhilreports//"+reportsFolder+"//screenshots"));
//		return System.getProperty("user.dir")+"//nikhilreports//"+reportsFolder+"//screenshots");
		
		TakesScreenshot ts = (TakesScreenshot)driver;  // ---check where here driver current is coming or not-----------------
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//rockstar//"+testcasename+".png");
		FileHandler.copy(source, file);
		
		return System.getProperty("user.dir")+"//rockstar//"+testcasename+".png";
		
		
	}
	

	
	@AfterMethod    // relating to StandAloneTest class because it extends this base class  and it have only one method
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();    //..............here driver is the one which testclassfile is refering.................................
	}
	
	
	
}
