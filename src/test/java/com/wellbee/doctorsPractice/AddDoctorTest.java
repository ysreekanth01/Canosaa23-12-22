package com.wellbee.doctorsPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddDoctorTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		String expOutput="General Physician";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//logining into application
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
		
		//Giving creditials 
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@12345");
		driver.findElement(By.name("submit")).click();
		
		//Click on doctor module
		driver.findElement(By.xpath("//span[text()=' Doctors '] ")).click();
		driver.findElement(By.xpath("//a[@href='add-doctor.php']/span")).click();
		
		driver.findElement(By.xpath("//select[@name='Doctorspecialization']")).click();
		
		List<WebElement> special = driver.findElements(By.xpath("//select/option"));
		for(WebElement sp:special)
		{
			String spText=sp.getText();
			if(spText.equals(expOutput)) {
				sp.click();
			}
		}
		driver.findElement(By.xpath("//input[@name='docname']")).click();
		

	}

}
