package com.wellbee.doctorsPractice;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddDoctorCheckIT {

	public static void main(String[] args) throws Exception {
		WebDriver driver=null;
		
		FileInputStream fis=new FileInputStream("./src/test/resources/expectedOutput.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url1 = prop.getProperty("url");
		String browser1 = prop.getProperty("browser");
		if(browser1.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser1.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		 FileInputStream fis1=new FileInputStream("./src/test/resources/ExpectedDataSpecialization.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		String expectedSpecialization= workbook.getSheet("Sheet1").getRow(3).getCell(2).getStringCellValue();
		String email= workbook.getSheet("Sheet1").getRow(4).getCell(2).getStringCellValue();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url1);
		
		
		//org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Sheet1");
		//Row row = sheet.getRow(2);
		//Cell cell = row.getCell(2);
		String data = workbook.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();// Hearty1
		
			driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
			
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@12345");
			driver.findElement(By.name("submit")).click();
			
//			driver.findElement(By.xpath("//span[text()=' Doctors '] ")).click();
//			driver.findElement(By.xpath("//span[text()=' Doctor Specialization ']")).click();
//			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(data);
//			driver.findElement(By.xpath("//button[@type='submit']")).click();
//			
//			List<WebElement> specializations = driver.findElements(By.xpath("//table[@id='sample-table-1']/tbody/tr/td[@class='hidden-xs']"));
//			for(WebElement webElements:specializations) {
//				String actualSpecializationName=webElements.getText();
//				if(actualSpecializationName.equals(expectedSpecialization)) {
//					System.out.println("Specialization Added Successfully");
//					break;
//				}
//			}
			
//			Thread.sleep(3000);
//			WebDriverWait wait = new WebDriverWait(driver,30);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='panel-body']/p"))).click();
			driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
			driver.findElement(By.xpath("//a[@href='add-doctor.php']")).click();
			driver.findElement(By.xpath("//select[@name='Doctorspecialization']")).click();
			String docName=workbook.getSheet("Sheet1").getRow(5).getCell(2).getStringCellValue();
			List<WebElement> allSpecs = driver.findElements(By.xpath("//option"));
			for(WebElement as:allSpecs)
			{
			String specialization=as.getText();	
			if(specialization.equals(data)) {
				as.click();
			
			}
			

		}
			
			driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Name']")).sendKeys(docName);
			driver.findElement(By.xpath("//textarea[@name='clinicaddress']")).sendKeys("Btm layout, Bangalore");
			driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Consultancy Fees']")).sendKeys("1200");
			driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Contact no']")).sendKeys("9876543210");
			driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Email id']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@placeholder='New Password']")).sendKeys("sreekanth");
			driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys("sreekanth");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			WebDriverWait wait1=new WebDriverWait(driver,10);
			wait1.until(ExpectedConditions.alertIsPresent());
			
			Alert a = driver.switchTo().alert();
			a.accept();
		
			
			List<WebElement> validation = driver.findElements(By.xpath("//tbody/tr/td[3]"));
			for(WebElement vd:validation) {
				String text = vd.getText();
				//System.out.println(text);
				if(text.equals("hi")) {
				System.out.println("Sucessfully doctor details added");
				}
				
			}
			
}}
