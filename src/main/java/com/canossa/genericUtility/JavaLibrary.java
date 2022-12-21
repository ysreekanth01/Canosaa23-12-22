package com.canossa.genericUtility;

public class JavaLibrary {
	Object convertedData;
	
	/**
	 * To convert String to Numeric
	 * @param value
	 * @param strategy
	 * @return
	 */
	public Object converStringToNumeric(String value,String strategy) {
		if(strategy.equals("long")) {
			convertedData = Long.parseLong(value);
			//return convertedData;
			
		}
		else if(strategy.equals("int")) {
			 convertedData=Integer.parseInt(value);
		}
		return convertedData;
	}

	
	
	
	
}
