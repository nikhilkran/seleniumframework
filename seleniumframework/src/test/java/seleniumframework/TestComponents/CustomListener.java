package seleniumframework.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import seleniumframework.ExtentManagerReport.ExtentManager;

public class CustomListener extends BaseTest implements ITestListener  {
	
	// for every METHOD it monitors result..
	
	ExtentReports extent = ExtentManager.getReports();   
	ExtentTest test;
	WebDriver driver;
	
	// when running paralley the second test can override the first one..
	// extra line added..
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal();
	
    public void onTestStart(ITestResult result) {    
		test= extent.createTest(result.getMethod().getMethodName());
		
		// extra line added
		extentTest.set(test); 
	}


	public void onTestFailure(ITestResult result) {
//		System.out.println("----Listener magic---------");
//		System.out.println(result.getName());
//		System.out.println(result.getStatus());
//		System.out.println(result.getThrowable().getMessage());
		
		
//		extentTest.get().fail(result.getThrowable());
		test.log(Status.FAIL,	((ITestResult) extentTest.get()).getThrowable().getMessage());    // instead of test--->extentTest.get()

		//screenshot
		String filepath =null;
		// getting driver from a class level hence used getTestClass().getRealClass()..
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		
		try {
			filepath= getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
		

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS,"TestPassed");
	}
	
	
	public void onTestSkipped(ITestResult result) {
		
	}
	//------------------------------------------------------------------------------------------------------------------------
	
	public void onStart(ITestContext context) {
		
	}
	
	public void onFinish(ITestContext context) {    //V.VIMP- here mistake of ITestContext happening previously and due to which report is not getting generated..
		extent.flush();
	}
	
}
