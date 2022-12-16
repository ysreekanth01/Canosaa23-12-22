package com.canossa.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener {
	ExtentReports report;
	ExtentTest test;


	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/canossa.html");// loc of the report
		spark.config().setDocumentTitle("Canossa Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Automation Test Report");
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating syatem", "windows11");
		report.setSystemInfo("browser", "chrome");	
	}
	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		test = report.createTest(arg0.getMethod().getMethodName());
		ThreadSafe.setExtentTest(test);
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		String path = ThreadSafe.getWebdriverUtility().takeScreenShot(arg0.getMethod().getMethodName());
		//test.fail(arg0.getThrowable());
		ThreadSafe.getExtentTest().fail(arg0.getThrowable());
		ThreadSafe.getExtentTest().addScreenCaptureFromPath(path, arg0.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		//test.skip(arg0.getThrowable());
		ThreadSafe.getExtentTest().skip(arg0.getThrowable());
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		//test.pass("test case is passed");
		ThreadSafe.getExtentTest().pass(arg0.getThrowable());
	}
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		report.flush();
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
