package com.hrm.common;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import generics.Utility;



public class CustomListeners implements ITestListener {

//	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void onTestFailure(ITestResult result) {

	String folder = AutomationConstants.SNAP_PATH;
		
			Utility.takeDesktopScreenshot(folder);
		} 
		
	

//	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
