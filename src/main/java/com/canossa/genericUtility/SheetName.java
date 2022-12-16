package com.canossa.genericUtility;

public enum SheetName {
	
	DOCTOR("Doctor");
	private String sheetName;

	private SheetName(String sheetName ) {
	this.sheetName=sheetName;
	}
	
	/**
	 * To convert to String 
	 * @return
	 */
	public String convertToString() {
		return sheetName.toString();
	}
	
	

}
