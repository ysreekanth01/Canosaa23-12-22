package com.wellbee.doctorsPractice;

import org.testng.annotations.DataProvider;

import com.canossa.genericUtility.ExecelUtility;

public class TestNgDataProvider {
	
	public void test(String username, String password) {
		System.out.println("username--->" +username+ "password---->" +password);
	}
	
	@DataProvider
	public String[][] getData(){
		ExecelUtility execelUtility=new ExecelUtility();
		
		return null;
		
	}

}
