package com.canossa.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeCommonPage {

  @FindBy(xpath = "//div[@class='button']//a[@href='hms/user-login.php']") private WebElement patientsModuleBtn;
  @FindBy(xpath = "//div[@class='button']//a[@href='hms/doctor/']") private WebElement doctorsModuleBtn;
  @FindBy(xpath = "//div[@class='button']//a[@href='hms/admin']") private WebElement adminModuleBtn;
  
  public HomeCommonPage(WebDriver driver){
	  PageFactory.initElements(driver, this);
  }
  
  /**
   * To click on patient module
   */
  public void patientModuleClick() {
	  patientsModuleBtn.click();
  }
  
  /**
   * To click on doctor module
   */
  public void doctorModuleClick() {
	  doctorsModuleBtn.click();
  }
  
  /**
   * To click on admin Module
   */
  public void adminModulelick() {
	  adminModuleBtn.click();
  }

}
