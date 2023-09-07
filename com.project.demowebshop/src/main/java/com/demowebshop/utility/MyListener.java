package com.demowebshop.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//ITestListener = to log testing activity
public class MyListener implements ITestListener{
	
	ExtentReports ereport;
	ExtentTest etest;
	ScreenShotUtility sc;

	@Override
	public void onTestStart(ITestResult result) {
		//System.out.println("onTestStart");
		etest.log(LogStatus.INFO, result.getMethod().getMethodName()+ " has started");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.out.println("onTestSuccess");
		etest.log(LogStatus.PASS, result.getMethod().getMethodName()+" has successfully passed");
		try {
			etest.log(LogStatus.PASS, "Screenshot "+etest.addScreenCapture(sc.takeScreenShot()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//System.out.println("onTestFailure");
		etest.log(LogStatus.FAIL, result.getMethod().getMethodName()+" has failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//System.out.println("onTestSkipped");
		etest.log(LogStatus.SKIP, result.getMethod().getMethodName()+" is skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStartTestNG");
		
		try {
			sc = new ScreenShotUtility();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ereport = new ExtentReports(".\\test-output\\ExtentReports\\MyReport.html");
		etest = ereport.startTest("Extent Report Practice");
		ereport.addSystemInfo("Browser","Chrome");
		ereport.addSystemInfo("Build","Smoke Testing");
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinishTestNG");
		
		ereport.endTest(etest);
		ereport.flush();
		
	}

}
