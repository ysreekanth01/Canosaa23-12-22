 package com.canossa.genericUtility;
import java.util.ArrayList;

import com.aventstack.extentreports.ExtentTest;
import com.canossa.genericUtility.WebDriverUtility;

public class ThreadSafe {
	
	
	
	private static ThreadLocal<WebDriverUtility> webdriverUtility=new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
	
	public static void setWebdriverUtility(WebDriverUtility swebdriverUtility) {
		webdriverUtility.set(swebdriverUtility);
	}
	
	public static  WebDriverUtility getWebdriverUtility() {
		return webdriverUtility.get();
	}
	
	public static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}
	
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}
	

}
