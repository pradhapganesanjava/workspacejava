package com.pg.java.xml.jaxb.topojo.rowmap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement (name="Accounts")
@XmlAccessorType (XmlAccessType.NONE)
public class MapWrapper{

	final String ACC = "Account";

	@XmlElement(name=ACC)
	//@XmlElement
	private List<MapXml<String, Object>> items = new ArrayList<MapXml<String,Object>>();

	public List<MapXml<String, Object>> getItems() {
		return items;
	}

	public void setItems(List<MapXml<String, Object>> items) {
		this.items = items;
	}

}
