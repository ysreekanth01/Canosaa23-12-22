package com.wellbee.doctorsPractice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/canossa.html");
		spark.config().setDocumentTitle("Canossa Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Automation Test Report");
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating syatem", "windows11");
		report.setSystemInfo("browser", "chrome");
		ExtentTest test1 = report.createTest("TestCase1");
		test1.pass("pass");
		
		ExtentTest test2 = report.createTest("TestCase2");
		test2.fail("fail");
		System.out.println("end");
		
		
		report.flush();
		

	}

}
