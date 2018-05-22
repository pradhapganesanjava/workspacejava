package com.pg.java.xml.jaxb.topojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement (name="AccountRoot")
public class GenRoot {

	private GenMapWrap<String, Object> mpr = new GenMapWrap<String, Object>();

	@XmlElement //(name="Account")
	@XmlJavaTypeAdapter(GenMapXmlAdapter.class)
	public GenMapWrap<String, Object> getMpr() {
		return mpr;
	}

	public void setMpr(GenMapWrap<String, Object> mpr) {
		this.mpr = mpr;
	}
}
