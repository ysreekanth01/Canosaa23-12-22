package com.wellbee.doctorsPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.canossa.genericUtility.ThreadSafe;
import com.canossa.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
		WebDriverUtility wb=new WebDriverUtility();
		
		ThreadSafe.getWebdriverUtility().takeScreenShot("");
		
		driver.close();
	}

}
