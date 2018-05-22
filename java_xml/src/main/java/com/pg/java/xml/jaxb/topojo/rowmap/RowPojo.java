package com.pg.java.xml.jaxb.topojo.rowmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/*@XmlRootElement(name="ROWS")
public class RowPojo {


	private List<Map<String, String>> mpLst = new ArrayList<Map<String,String>>();

	//@XmlElement(name="ROW")
	@XmlJavaTypeAdapter(RowMapXmlAdapter.class)
	public List<Map<String, String>> getMpLst() {
		return mpLst;
	}

	public void setMpLst(List<Map<String, String>> mpLst) {
		this.mpLst = mpLst;
	}
}
*/
@XmlRootElement(name="ROW")
public class RowPojo extends ArrayList<Map<String, String>>{

	private static final long serialVersionUID = 1L;
	
	private Map<String, String> item;

	@XmlJavaTypeAdapter(RowMapXmlAdapter.class)
	public Map<String, String> getItem() {
		return item;
	}

	public void setItem(Map<String, String> item) {
		this.item = item;
	}
}
