package com.pg.java.xml.jaxb.topojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement (name="root")
@XmlAccessorType (XmlAccessType.NONE)
public class ListMapWrap{

	final String ACC = "Account";
	

	@XmlElement(name=ACC)
	//@XmlElement
	private List<MapWrap<String, Object>> items = new ArrayList<MapWrap<String,Object>>();

	public List<MapWrap<String, Object>> getItems() {
		return items;
	}

	public void setItems(List<MapWrap<String, Object>> items) {
		this.items = items;
	}

}
