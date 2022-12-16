package com.canossa.objectRepository;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.canossa.genericUtility.WebDriverUtility;

public class AddDoctorPage {
	
	@FindBy(xpath = "//span[text()=' Doctors ']")
	private WebElement clickDoctor;
	@FindBy(xpath = "//a[@href='add-doctor.php']")
	private WebElement clickAddDoctor;
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement clickDoctorSpecialization;
	@FindBy(xpath = "//input[@placeholder='Enter Doctor Name']")
	private WebElement doctorName;
	@FindBy(xpath = "//textarea[@name='clinicaddress']")
	private WebElement doctorAddress;
	@FindBy(xpath = "//input[@placeholder='Enter Doctor Consultancy Fees']")
	private WebElement doctorFees;
	@FindBy(xpath = "//input[@placeholder='Enter Doctor Contact no']")
	private WebElement doctorContacts;
	@FindBy(xpath = "//input[@placeholder='Enter Doctor Email id']")
	private WebElement doctorEmail;
	@FindBy(xpath = "//input[@placeholder='New Password']")
	private WebElement doctorNewPassword;
	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	private WebElement doctorConfirmPassword;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement doctorClickSubmit;
	@FindBy(xpath = "//div[@class='panel-body']/p")
	private WebElement xpath1;
	@FindBy(xpath = "option")
	private List<WebElement> allSpecialization;
	@FindBy(className = "form-control") 
	private WebElement allSpecs;
	

	public  AddDoctorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Use to add doctor details and submit them
	 * @param docName
	 * @param docAddress
	 * @param docFees
	 * @param docContactNumber
	 * @param docEmail
	 * @param docNewPassword
	 * @param docConfirmPassword
	 * @param expectedDoctorName
	 */
	public void addDoctor(String docName, String docAddress, String docFees,
			String docContactNumber, String docEmail, String docNewPassword,
			String docConfirmPassword, String expectedDoctorName)
	{
	
		clickDoctorSpecialization.click();
		

		
		WebElement allspecs1= allSpecs;
		Select s=new Select(allspecs1);
		List<WebElement> all = s.getOptions();
		for(WebElement wb:all) {
			String tx=wb.getText();
			if(tx.equals(expectedDoctorName))
				wb.click();
		}
			
		
		doctorName.sendKeys(docName);
		doctorAddress.sendKeys(docAddress);
		doctorFees.sendKeys(docFees);
		doctorContacts.sendKeys(docContactNumber);
		Random rb=new Random();
		int ran = rb.nextInt(1000);
		doctorEmail.sendKeys(docEmail+ran);
		doctorNewPassword.sendKeys(docNewPassword);
		doctorConfirmPassword.sendKeys(docConfirmPassword);
		doctorClickSubmit.click();
		
		
		
		
		//WebDriverUtility wdu=new WebDriverUtility();
		//wdu.explicitWait("presenceOfElementLocated", By.xpath("//div[@class='panel-body']/p"));
		}}
