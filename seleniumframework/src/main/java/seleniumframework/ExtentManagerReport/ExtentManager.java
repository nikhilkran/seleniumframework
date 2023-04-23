package seleniumframework.ExtentManagerReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	

		

 
		
		public static ExtentReports getReports() {
//			if(reports == null) {     // not to get replace when we want to run our framework again(i,e such as rerunning failed test cases,second data sets..)
//				reports = new ExtentReports();
				//init the report folder
//				Date d = new Date();  // concept how we can avoid getting resukts in same file...
//				String reportsFolder=d.toString().replaceAll(":", "-");
				
//				String screenshotFolderPath=System.getProperty("user.dir")+"//nikhilreports//"+reportsFolder+"//screenshots";	
//				String reportFolderPath=System.getProperty("user.dir")+"//nikhilreports//"+reportsFolder;
//				File f = new File(screenshotFolderPath);
//				f.mkdirs();
				String reportFolderPath=System.getProperty("user.dir")+"//rockstar//index.html";
				ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFolderPath);
				// setting report configurations
				sparkReporter.config().setReportName("learning selenium");
				sparkReporter.config().setDocumentTitle("nikhil report");
				sparkReporter.config().setTheme(Theme.STANDARD);
				sparkReporter.config().setEncoding("utf-8");
				
				ExtentReports reports = new ExtentReports();
				
				reports.attachReporter(sparkReporter);
//			}
			return reports;
		}
		
	}

