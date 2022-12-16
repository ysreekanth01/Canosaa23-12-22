package com.canossa.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//PropertyFileUtility fu=new PropertyFileUtility();
	//String timeout=fu.getPropertyFileData(PropertyFileKeys.TIMEOUT.convertToString());
	//JavaLibrary jv=new JavaLibrary();
	//long sec=jv.converStringToLong(timeout);
	
	/**
	 * Use to launch Application 
	 * @param browser
	 * @param timeout
	 * @param url
	 * @return
	 */
	public WebDriver launchApplication(String browser, long timeout, String url ) {
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Please enter valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
		}
	
	/**
	 * Used for explicit wait
	 * @param typeWait
	 * @param element
	 */
	public void explicitWait(String typeWait, By element)
	{
		if(typeWait.equals("presenceOfElementLocated")){
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		
		}
		else if(typeWait.equals("alertIsPresent")) {
			wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent());

		}
	}
	
	/**
	 * Used for alert popup handling
	 * @return
	 */
	public Alert alertPopUp()
	{
		Alert a1 = driver.switchTo().alert();
		return a1;
	}
	
	/**
	 * This method is use to wait till specified element visible
	 * @param element
	 */
	public void waitTillElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method os used to wait till the page element changed the text
	 */
	
	public void waitTillElementTextInVisible(By element, String text) {
		wait.until(ExpectedConditions.invisibilityOfElementWithText(element, text));
	}
	public String takeScreenShot(String name) {
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/"+name+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dst.getAbsolutePath();
		
	}
	
	}

