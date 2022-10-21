package com.utilities;

import java.io.IOException;
import java.util.logging.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utilities.Constants;

public class GenerateReports {
	 ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	private static GenerateReports ob;
	
	public static GenerateReports getInstance() {
		if (ob==null) {
			ob = new GenerateReports();
			
		}
		return ob;
	}
	
	public void startExtentReport() {
		htmlReporter = new ExtentHtmlReporter(Constants.GENERATE_REPORT_PATH);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Salesforce");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "mail2raju@2001");
		htmlReporter.config().setDocumentTitle("Test Execution Report");
		htmlReporter.config().setReportName("firebase regression tests");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
		public void startsSingleTestReport(String testname) {
			logger = extent.createTest(testname);
		}
		
		public void logTestInfo(String message) {
			logger.log(Status.INFO,message);
		}
		public void logPass(String message) {
			logger.log(Status.PASS,message);
		}
		public void logFail(String message) {
			logger.log(Status.FAIL,message);
		}
		public void logTestPassed(String testcasename) {
			logger.log(Status.PASS, MarkupHelper.createLabel("testcasename" + "is passTest",ExtentColor.GREEN));
		}
		
         
		public void logTestfailed(String testcasename) {
			logger.log(Status.FAIL, MarkupHelper.createLabel("testcasename" + "is not passTest",

					ExtentColor.RED));
		}
		
		public void logTestSkipped(String testcasename) {
			logger.log(Status.SKIP, MarkupHelper.createLabel("testcasename" + "is not passTest",

					ExtentColor.ORANGE));
		}
		public void endReport() {
		
			extent.flush();
		}
		public void addScreenshot(String file, String title) throws IOException {
			logger.addScreenCaptureFromPath(file, title);
		}

			
		
		
		
		
	
	


}
