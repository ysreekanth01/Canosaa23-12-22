package com.canossa.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminCommonPage {
	
	@FindBy(xpath = "//span[text()=' Dashboard ']") private WebElement dashboard;
	@FindBy(xpath = "//span[text()=' Doctors ']") private WebElement doctor;
	@FindBy(xpath = "//span[text()=' Doctor Specialization ']") private WebElement doctorSpecialization;
	@FindBy(xpath = "//span[text()=' Add Doctor']") private WebElement addDoctor;
	@FindBy(xpath = "//span[text()=' Manage Doctors ']") private WebElement manageDoctor;
	@FindBy(xpath = "//span[text()=' Users ']") private WebElement user;
	@FindBy(xpath = "//span[text()=' Manage Users ']") private WebElement manageUser;
	@FindBy(xpath = "//span[text()=' Patients ']") private WebElement managePatients;
	@FindBy(xpath = " Appointment History ") private WebElement appointmentHistory;
	
	
	public AdminCommonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * To click on dashboard
	 */
	
	public void dashboardClick() {
		dashboard.click();
		
	}
	
	/**
	 * to click on doctor specialization
	 */
	public void doctorSpecializationClick() {
		doctor.click();
		doctorSpecialization.click();
	}
	
	/**
	 * to click on add doctor
	 */
	public void addDoctorClick() {
		doctor.click();
		addDoctor.click();
		
	}
	
	/**
	 * To click on manage doctor
	 */
	public void manageDoctorClick() {
		doctor.click();
		manageDoctor.click();
		
	}
	
	
}
