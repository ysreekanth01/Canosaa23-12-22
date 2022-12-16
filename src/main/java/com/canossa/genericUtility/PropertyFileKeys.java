package com.canossa.genericUtility;

public enum PropertyFileKeys {
	BROWSER("browser"), URL("url"), USERNAME("Username"), PASSWORD("Password"), TIMEOUT("timeout"), 
	DOCTOR_ADDRESS("DocAddress"), DOCTOR_FEES("doctorFee"), DOCTOR_CONTACT("doctorContactNumber"),
	DOCTOR_NAME("DocName"),DOCTOR_NUMBER("doctorNumber"),DOCTOR_EMAIL("DoctorEmail"),
	DOCTOR_NEW_PASSWORD("DoctorNewPassword"),DOCTOR_CONFIRM_PASSWORD("DoctorConfirmPassword"),URLTY("urlTy");
	
	private String keys;
	
	private PropertyFileKeys(String keys) {
		this.keys=keys;
	}
	
	/**
	 * To convert to String
	 * @return
	 */
	public String convertToString() {
		return keys.toString();
	}

	
	
	
	
	

}
