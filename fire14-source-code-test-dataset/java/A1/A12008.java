package com.utility;

public enum Constants {
	BLANK(""),
	
	SPACE_REG_EXP("\\s+"),
	
	RESOURCES_LOCATION("/Users/sandeep/Work/WorkSpace/Sample/src/main/resources/");
	
	private void Constants() {
	}
	
	
	
	private Constants(String constant) {
		this.constant = constant;
	}



	private String constant;

	public String getConstant() {
		return constant;
	}

	public void setConstant(String constant) {
		this.constant = constant;
	}
	
	
	
}
