package com.canossa.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
		@FindBy(xpath="//a[@href='hms/admin']")
		private WebElement adminClick;
		
		@FindBy(xpath="//input[@name='username']") 
		private WebElement username;
		
		@FindBy(xpath="//input[@name='password']") 
		private WebElement password;
		
		@FindBy(name="submit")
		private WebElement submit;
		
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		/**
		 * To login the page
		 * @param username1
		 * @param password1
		 */
		public void loginAction(String username1, String password1 )
		{
		username.sendKeys(username1);
		password.sendKeys(password1);
		submit.click();

	}}

