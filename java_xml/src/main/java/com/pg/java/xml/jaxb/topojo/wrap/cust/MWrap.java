package com.pg.java.xml.jaxb.topojo.wrap.cust;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlRootElement(name="Account")
public class MWrap<String, Object> extends HashMap<String, String> {/*

	Map<String, Object> mItem = new HashMap<>();


	public Map<String, Object> getmItem() {
		return mItem;
	}

	public void setmItem(Map<String, Object> mItem) {
		this.mItem = mItem;
	}
*/}
