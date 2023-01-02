package com.canossa.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;
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
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
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
	 * This method is used to wait untill element click
	 * @param duration
	 * @param element
	 * @param pollingTime
	 * @throws InterruptedException
	 */
	public void waitAndClick(int duration, WebElement element, long pollingTime) throws InterruptedException {
		int count=0;
		while(count<duration) {//duration=10
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(pollingTime);//polling time = 1000
				count++;
			}
		}
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
			 
			e.printStackTrace();
		}
		return dst.getAbsolutePath();

	}
	public String takeScreenShot() {
		TakesScreenshot t=(TakesScreenshot) driver;
		String src = t.getScreenshotAs(OutputType.BASE64);
		return src;
	}
	

	/**
	 * This method is used to scrool till the end of webpage
	 */
	public void scrollTillEnd() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * This method is used to enter value using java script code
	 * @param element
	 * @param data
	 */
	public void enterValueUsingJs(WebElement element, String data) {
		js.executeScript("arguments[0].value=arguments[1]",element,data);
	}

	/**
	 * This method is used to click on the element
	 * @param element
	 */
	public void clickUsingJs(WebElement element) {
		js.executeScript("arguments[0].click()",element);
	}

	/**
	 * This method is used to switch the window based on partial URL
	 * @param driver
	 * @param partialText
	 */
	public void switchWindow(String partialURLorTitle, String strategy) {
		Set<String> windowIDs = driver.getWindowHandles();
		for (String id : windowIDs) {
			driver.switchTo().window(id);
			if(strategy.equals("url")) {
				String actualUrl = driver.getCurrentUrl();
				if(actualUrl.contains(partialURLorTitle)) {
					break;
				}
			}
			else if(strategy.equals("title")) {
				String actualTitle = driver.getTitle();
				if(actualTitle.contains(partialURLorTitle)) {
					break;
				}
			}
		}
	}



	/**
	 * This method is used to mouse hover on the specified element
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		act.moveToElement(element).perform();
	}



	/**
	 * This method is used to double click on the specified element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebElement element) {
		act.doubleClick(element).perform();
	}

	/**
	 * This method is used to double click on the web page
	 * @param driver
	 */
	public void doubleClick() {
		act.doubleClick().perform();
	}

	/**
	 * This method is used to right click on the web page
	 * @param driver
	 */
	public void rightClick() {
		act.contextClick().perform();
	}

	/**
	 * This method is used to right click on the specified element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebElement element) {

		act.contextClick(element).perform();
	}


	/**
	 * This method is used to switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch the frame based on NAME or ID
	 * @param driver
	 * @param nameOrID
	 */
	public void switchFrame(String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}

	/**
	 * This method is used to switch the frame based on element
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebElement element) {
		driver.switchTo().frame(element);
	}


	/**
	 * This method is used to switch back parent frame of current frame (means just top of the current frame)
	 * @param driver
	 */
	public void switchPreviousFrame() {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method is used to switch back to webpage from frame(Take the controll back to home page)
	 * @param driver
	 * @param element
	 */
	public void switchBackFrame(WebElement element) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to accept alert popup
	 * @param driver
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to dissmiss alert popup
	 * @param driver
	 */
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to fetch data from alert popup
	 * @param driver
	 * @return
	 */
	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}


}

