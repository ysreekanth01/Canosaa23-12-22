package com.canossa.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class PropertyFileUtility {
	private FileInputStream propertyFis;
	private Properties p;
	
	/**
	 * To read data from Property file
	 * @param path
	 */
	public void openPropertyFile(String path) {
	
	
	try {
		propertyFis = new FileInputStream(path);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	
	p=new Properties();
	
	try {
		p.load(propertyFis);
	} catch (IOException e) {
		
		e.printStackTrace();
	}

	}
	
	/**
	 * To retrieve data from Property file 
	 * @param keys
	 * @return
	 */
	public String getPropertyFileData(String keys)
	{
		
		
		String value=p.getProperty(keys);
		return value;
		
		
		
		
		
		
//		String data=p.getProperty(key);
//		return data;
	}
//	String url1 = prop.getProperty(PropertyFileKeys.URL.convertToString());
//	String browser1 = prop.getProperty(PropertyFileKeys.BROWSER.convertToString());
//	String timeout = prop.getProperty(PropertyFileKeys.TIMEOUT.convertToString());
//	
     public void closeProperty() {
    	 try {
			propertyFis.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	 
}
}

