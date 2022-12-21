package com.canossa.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DoctorSpecializationPage
{
	@FindBy(xpath = "//input[@name='doctorspecilization']")
	private WebElement doctorSpecialzationClick;
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement addDoctorSpecialization;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addDoctorSpecializationSubmit;
	
	

	@FindBy(xpath = "//table[@id='sample-table-1']/tbody/tr/td[@class='hidden-xs']")
	private List<WebElement> specializations;
	
	
	
	public DoctorSpecializationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/**
	 * to pass doctor specialization 
	 * @param specialization
	 */
	public void addDoctorSpecialization(String specialization)
	{
		doctorSpecialzationClick.click();
		addDoctorSpecialization.sendKeys(specialization);
		addDoctorSpecializationSubmit.click();
		
		
		
	}
	
	/**
	 * To validate the doctor specialization
	 * @param expectedDocSpecialization
	 */
	public boolean validateSpecialization(String expectedDocSpecialization) {
		List<WebElement> validiationSpecialization=specializations;
		boolean flag=false;
		for(WebElement oneByOneValidiation:validiationSpecialization) {
			
			String actualSpecializationName=oneByOneValidiation.getText();
			
			if(actualSpecializationName.equals(expectedDocSpecialization)) {
				flag =true;
				System.out.println("Specialization Added Successfully");
				break;
			}
			
		}return flag;
	
	}
}
