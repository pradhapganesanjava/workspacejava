package com.pg.java.xml.jaxb.topojo.wrap.cust;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({MXmlAdapter.class})
public class MWrapper {
	 
    private List<MWrap<String, String>> items;
 
    public MWrapper() {
        items = new ArrayList<MWrap<String, String>>();
    }
 
    public MWrapper(List<MWrap<String, String>> items) {
        this.items = items;
    }
 
    @XmlAnyElement(lax=true)
    public List<MWrap<String, String>> getItems() {
        return items;
    }
 
}