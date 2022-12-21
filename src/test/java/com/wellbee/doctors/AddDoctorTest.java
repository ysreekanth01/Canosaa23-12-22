package com.wellbee.doctors;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.util.List;
	import java.util.Properties;
	import java.util.Random;
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
import org.testng.annotations.Test;

import com.canossa.genericUtility.BaseClass;

	import com.canossa.genericUtility.IConstantPath;

	import com.canossa.genericUtility.PropertyFileKeys;
	
	import com.canossa.genericUtility.SheetName;


	public class AddDoctorTest extends BaseClass {
	@Test(groups= {"regression","sanity"})
		public  void test() throws Exception {
		Thread.sleep(3000);

			String expectedDocSpecialization=execelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH,SheetName.DOCTOR.convertToString(), 2, 2);
			adminCommonPage.doctorSpecializationClick();
			
			
			doctorSpecializationPage.addDoctorSpecialization(expectedDocSpecialization);
			doctorSpecializationPage.validateSpecialization(expectedDocSpecialization);
			
			adminCommonPage.addDoctorClick();
			
			
			String doctorName=execelUtility.getDataFromExcel("./src/test/resources/ExpectedDataSpecialization.xlsx",SheetName.DOCTOR.convertToString(), 4, 2);
			String docAddress=propertyFileUtility.getPropertyFileData(PropertyFileKeys.DOCTOR_ADDRESS.convertToString());
			String docFee=propertyFileUtility.getPropertyFileData(PropertyFileKeys.DOCTOR_FEES.convertToString());
			String docContact=propertyFileUtility.getPropertyFileData(PropertyFileKeys.DOCTOR_CONTACT.convertToString());
			String docNewPwd=propertyFileUtility.getPropertyFileData(PropertyFileKeys.DOCTOR_NEW_PASSWORD.convertToString());
			String docConfirmPwd=propertyFileUtility.getPropertyFileData(PropertyFileKeys.DOCTOR_CONFIRM_PASSWORD.convertToString());
			String docEmailID=propertyFileUtility.getPropertyFileData(PropertyFileKeys.DOCTOR_EMAIL.convertToString());
			
			
			addDoctorPage.addDoctor(doctorName,docAddress, docFee, docContact,docEmailID, docNewPwd, docConfirmPwd , expectedDocSpecialization);
			
			webDriverUtility.alertPopUp().accept();
			
			manageDoctorsPage.docValidation(doctorName);
			//Assert.fail();

			String PartialXpath=manageDoctorsPage.getXpath();
		
			WebElement elem = manageDoctorsPage.StringToWebElement(driver, PartialXpath, doctorName);
			 elem.click();
			 String fees=propertyFileUtility.getPropertyFileData(PropertyFileKeys.DOCTOR_FEES.convertToString());
			 manageDoctorsPage.editDoctorFees(fees);		
			}
	}
