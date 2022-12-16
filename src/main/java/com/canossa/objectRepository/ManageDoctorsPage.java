package com.canossa.objectRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.canossa.genericUtility.ExecelUtility;
import com.canossa.genericUtility.SheetName;

public class ManageDoctorsPage {
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updateBtn;
	@FindBy(xpath= "//tbody/tr/td[3]")
	private List<WebElement> doctorValidation;
	@FindBy(xpath = "//input[@name='docfees']")
	private WebElement doctorFees;
	WebDriver driver;
	ExecelUtility eu=new ExecelUtility();
	String doctorName=eu.getDataFromExcel("./src/test/resources/ExpectedDataSpecialization.xlsx",SheetName.DOCTOR.convertToString(), 4, 2);
		
	String partialxpath="//table//tbody/tr/td[text()='%s']/following-sibling::td/following-sibling::td//i[@class='fa fa-pencil']";
		
		

		public ManageDoctorsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		/**
		 * Use to validate the doctor 
		 * @param doctorName
		 */
		public void docValidation(String doctorName)
		{
			List<WebElement> validation = doctorValidation;
			for(WebElement vd:validation) {
				String text = vd.getText();

				if(text.equals(doctorName)) {
					System.out.println("Sucessfully doctor added");
					break;
		}
			}
		}
		
		/**
		 * Use to edit the doctor details
		 * @param driver
		 * @param partialxpath
		 * @param expectedValue
		 * @return
		 */
		public WebElement StringToWebElement(WebDriver driver, String  partialxpath, String  expectedValue) {
			String xpath= String.format(partialxpath, expectedValue);
			return driver.findElement(By.xpath(xpath));
	}
	
		public String getXpath()
		{
			return partialxpath;
		}
		
		public void editDoctorFees(String fees) {
			WebElement fee = doctorFees;
			 fee.click();
			Robot r;
			try {
				r = new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_A);
				fee.sendKeys(fees);
				
				r.keyRelease(KeyEvent.VK_CONTROL);
			} catch (AWTException e) {
				
			}
			
			updateBtn.click();
			
		}
}
