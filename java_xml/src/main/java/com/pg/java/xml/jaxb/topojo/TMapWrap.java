package com.pg.java.xml.jaxb.topojo;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(TListXmlAdapter.class)
@XmlRootElement(name="Account")
public class TMapWrap<String, Object> extends HashMap<String, Object> {
	private static final long serialVersionUID = 7068224588726867418L;
}