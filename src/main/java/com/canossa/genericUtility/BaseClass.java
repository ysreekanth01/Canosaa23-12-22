
package com.canossa.genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.canossa.objectRepository.AddDoctorPage;
import com.canossa.objectRepository.AdminCommonPage;
import com.canossa.objectRepository.DoctorSpecializationPage;
import com.canossa.objectRepository.HomeCommonPage;
import com.canossa.objectRepository.LoginPage;
import com.canossa.objectRepository.LogoutPage;
import com.canossa.objectRepository.ManageDoctorsPage;

public class BaseClass {
	
	protected WebDriver driver;
	protected WebDriverUtility webDriverUtility;
	protected PropertyFileUtility propertyFileUtility;
	protected JavaLibrary javaLibrary;
	protected ExecelUtility execelUtility;
	protected LoginPage login;
	protected AdminCommonPage adminCommonPage;
	protected HomeCommonPage homeCommonPage;
	protected LogoutPage logout;
	protected DoctorSpecializationPage doctorSpecializationPage;
	protected AddDoctorPage addDoctorPage;
	protected ManageDoctorsPage manageDoctorsPage;

	
	@BeforeClass
	public void classSetup() {
		
		webDriverUtility= new WebDriverUtility();
		ThreadSafe.setWebdriverUtility(webDriverUtility);
		propertyFileUtility=new PropertyFileUtility();
		javaLibrary=new JavaLibrary();
		execelUtility=new ExecelUtility();
		
		
		propertyFileUtility.openPropertyFile(IConstantPath.PROPERTY_PATH);	
		String url1=propertyFileUtility.getPropertyFileData(PropertyFileKeys.URL.convertToString());
		String browser1 =propertyFileUtility.getPropertyFileData(PropertyFileKeys.BROWSER.convertToString());
		String timeout=propertyFileUtility.getPropertyFileData(PropertyFileKeys.TIMEOUT.convertToString());
		
		
		Long sec = (Long) javaLibrary.converStringToNumeric(timeout, "long");
		
		
		
		String email=execelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH,SheetName.DOCTOR.convertToString(), 4, 2);
		
		driver = webDriverUtility.launchApplication(browser1,sec, url1);
	
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		driver.get(url1);


		
		
		//create object for commom POM classes
		login=new LoginPage(driver);
		adminCommonPage=new AdminCommonPage(driver);
		homeCommonPage=new HomeCommonPage(driver);
		logout=new LogoutPage(driver);
		doctorSpecializationPage=new DoctorSpecializationPage(driver);
		addDoctorPage=new AddDoctorPage(driver);
		manageDoctorsPage=new ManageDoctorsPage(driver);
		
		
	}
	
	@BeforeMethod
	public void methodSetUp() {
	
		
		
		homeCommonPage.adminModulelick();
		String un=propertyFileUtility.getPropertyFileData(PropertyFileKeys.USERNAME.convertToString());
		String pwd=propertyFileUtility.getPropertyFileData(PropertyFileKeys.PASSWORD.convertToString());
		
		//LoginPage lp=new LoginPage(driver);
		login.loginAction(un, pwd);
	}
	
	@AfterMethod
	public void methodTearDown() {
		logout.clickLogout();
		
		
	}
	@AfterClass
	public void classTearDown() {
		
	}

}
