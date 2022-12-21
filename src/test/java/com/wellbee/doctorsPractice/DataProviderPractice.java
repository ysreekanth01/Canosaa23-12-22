package com.wellbee.doctorsPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "getDataProvider")
	public void dataProviderTest(String un,String pwd) {
		System.out.print("username---->"+un+"----------password---->"+pwd);
		
	}
	
	@DataProvider
	public Object[][] getDataProvider() {
		Object[][] ob=new Object[3][2];
		//1set of data
		ob[0][0]="admin";
		ob[0][1]="Test@15";
		// 2 set of data
		ob[1][0]="admin2";
		ob[1][1]="Test@123456";
		//3set of data
		ob[2][0]="admin3";
		ob[2][1]="Test@1234567";
		
		return  ob;
	}

}
