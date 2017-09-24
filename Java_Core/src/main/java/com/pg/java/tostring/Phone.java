package com.pg.java.tostring;

import java.util.List;


public class Phone implements AbsObject{

	private String phoneName = "iPhone";
	
	private PhoneFeature phoneFeatures = null;
	
	private List<PhoneFeature> phoneFeatureLst = null;
	
	public Phone() {
		this.phoneFeatures = new PhoneFeature("FM");
	}

	public Phone(String phoneName) {
		this.phoneName = phoneName;
		this.phoneFeatures = new PhoneFeature("FM");
	}
	
	@Override
	public String toMyString() {
		return phoneName + phoneFeatures.toMyString();
	}
}
