package com.pg.java.xml.jaxb.topojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name="Accounts")
public class TListWrap{
	
	private List<TMapWrap<String, Object>> items;

	@XmlAnyElement(lax=true)
	//@XmlElement(name="Account")
	public List<TMapWrap<String, Object>> getItems() {
		return items;
	}

	public void setItems(List<TMapWrap<String, Object>> items) {
		this.items = items;
	}
}



