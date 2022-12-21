package com.canossa.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplimentationClass implements IRetryAnalyzer {
	int count=0;
	int retryLimit=3;
	@Override
	public boolean retry(ITestResult result) {
		if(count<retryLimit) {
			count++;
			return true;
		}
		return false;
	}
}
