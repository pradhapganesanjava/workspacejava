package com.pg.java.understand.tostring;

public class PhoneFeature implements AbsObject{
	
	private String featureName="Touch";
	
	public PhoneFeature() {
	}
	
	public PhoneFeature(String featureName) {
		this.featureName = featureName;
	}
	
	@Override
	public String toMyString() {
		return featureName;
	}

}
