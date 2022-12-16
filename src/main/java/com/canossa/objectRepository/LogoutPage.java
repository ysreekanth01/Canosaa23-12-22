package com.canossa.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	@FindBy(xpath = "//span[@class='username']") private WebElement userClick;
	@FindBy(xpath = "//a[@href='logout.php']") private WebElement logOutClick;
	
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * To logout the application
	 */
public void clickLogout() {
	userClick.click();
	logOutClick.click();
}

}
