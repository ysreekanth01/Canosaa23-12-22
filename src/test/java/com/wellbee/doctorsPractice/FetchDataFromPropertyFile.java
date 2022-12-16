package com.wellbee.doctorsPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class FetchDataFromPropertyFile {

	public  String fetchData(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/expectedOutput.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
		

	}

}
