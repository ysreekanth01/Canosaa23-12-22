package com.wellbee.doctors;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
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
	@Test
	public void addDoctorIT() {
		

		String expectedDocSpecialization=execelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH,SheetName.DOCTOR.convertToString(), 2, 2);
		adminCommonPage.doctorSpecializationClick();
		doctorSpecializationPage.addDoctorSpecialization(expectedDocSpecialization);
		doctorSpecializationPage.validateSpecialization(expectedDocSpecialization);
		
	}

}
