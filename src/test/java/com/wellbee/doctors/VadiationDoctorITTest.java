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
import org.testng.annotations.Test;

import com.canossa.genericUtility.ExecelUtility;
	import com.canossa.genericUtility.PropertyFileUtility;
	import com.canossa.genericUtility.IConstantPath;
	import com.canossa.genericUtility.JavaLibrary;
	import com.canossa.genericUtility.PropertyFileKeys;
	import com.canossa.genericUtility.PropertyFileUtility;
	import com.canossa.genericUtility.SheetName;
	import com.canossa.genericUtility.WebDriverUtility;

import com.canossa.objectRepository.AdminCommonPage;

//import com.canossa.objectRepository.DoctorSpecialization;
import com.canossa.objectRepository.DoctorSpecializationPage;
import com.canossa.objectRepository.HomeCommonPage;
import com.canossa.objectRepository.LoginPage;
import com.canossa.objectRepository.LogoutPage;
import com.canossa.objectRepository.ManageDoctorsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VadiationDoctorITTest  {
@Test(groups="sanity")
		public static void test2() throws Exception {

			PropertyFileUtility fu=new PropertyFileUtility();
			fu.openPropertyFile(IConstantPath.PROPERTY_PATH);	
			String url1=fu.getPropertyFileData(PropertyFileKeys.URL.convertToString());
			String browser1 =fu.getPropertyFileData(PropertyFileKeys.BROWSER.convertToString());
			String timeout=fu.getPropertyFileData(PropertyFileKeys.TIMEOUT.convertToString());

			JavaLibrary jv=new JavaLibrary();
			Long sec = (Long) jv.converStringToNumeric(timeout, "long");
			
			ExecelUtility eu=new ExecelUtility();
			//String expectedSpecialization=eu.getDataFromExcel(IConstantPath.EXCEL_PATH,SheetName.DOCTOR.convertToString(),3,2);//Brain
			String email=eu.getDataFromExcel(IConstantPath.EXCEL_PATH,SheetName.DOCTOR.convertToString(), 4, 2);
			
			WebDriverUtility webDriverUtility= new WebDriverUtility();
			WebDriver driver = webDriverUtility.launchApplication(browser1,sec, url1);
		
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
			driver.get(url1);


			String expectedDocSpecialization=eu.getDataFromExcel(IConstantPath.EXCEL_PATH,SheetName.DOCTOR.convertToString(), 2, 2);
			String un=fu.getPropertyFileData(PropertyFileKeys.USERNAME.convertToString());
			String pwd=fu.getPropertyFileData(PropertyFileKeys.PASSWORD.convertToString());

				
			HomeCommonPage hcp=new HomeCommonPage(driver);
			hcp.adminModulelick();
			
			LoginPage lp=new LoginPage(driver);
			lp.loginAction(un, pwd);
			
			AdminCommonPage acp=new AdminCommonPage(driver);
			acp.manageDoctorClick();
			
		
			
			
			
			String doctorName=eu.getDataFromExcel("./src/test/resources/ExpectedDataSpecialization.xlsx",SheetName.DOCTOR.convertToString(), 4, 2);
			ManageDoctorsPage mdp=new ManageDoctorsPage(driver);
			mdp.docValidation(doctorName);
			
			
			
		}			

}
