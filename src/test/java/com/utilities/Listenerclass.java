package com.utilities;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listenerclass implements ITestListener{

	GenerateReports report = GenerateReports.getInstance();
	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			report.logTestfailed(result.getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	@Override
	public void onTestSuccess(ITestResult result) {
		report.logTestPassed(result.getName());
		
		
	}
		
	
	
	
	
}
