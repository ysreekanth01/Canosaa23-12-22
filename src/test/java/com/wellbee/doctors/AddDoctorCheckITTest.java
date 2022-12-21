package com.wellbee.doctors;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.canossa.genericUtility.BaseClass;
import com.canossa.genericUtility.ExecelUtility;
import com.canossa.genericUtility.IConstantPath;
import com.canossa.genericUtility.JavaLibrary;
import com.canossa.genericUtility.PropertyFileKeys;
import com.canossa.genericUtility.PropertyFileUtility;
import com.canossa.genericUtility.SheetName;
import com.canossa.genericUtility.WebDriverUtility;
import com.canossa.objectRepository.AdminCommonPage;
import com.canossa.objectRepository.DoctorSpecializationPage;
import com.canossa.objectRepository.HomeCommonPage;
import com.canossa.objectRepository.LoginPage;

public class AddDoctorCheckITTest extends BaseClass {
	
	//@Parameters(value= {"browser"})
	@Test
	
	public void addDoctorIT() throws InterruptedException {
		
		Thread.sleep(3000);
		String expectedDocSpecialization=execelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH,SheetName.DOCTOR.convertToString(), 2, 2);
		adminCommonPage.doctorSpecializationClick();
		doctorSpecializationPage.addDoctorSpecialization(expectedDocSpecialization);
		boolean flag = doctorSpecializationPage.validateSpecialization(expectedDocSpecialization);
		if(!flag)
		{
			Assert.fail();
		}
		
	}
	@Test
	public void sampleTest() {
		System.out.println("sample test");
	}

}
