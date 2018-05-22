package com.pg.java.xml.jaxb.topojo.rowmap;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(MapXmlAdapter.class)
public class MapXml<String, Object> extends HashMap<String, Object> {
	private static final long serialVersionUID = 7068224588726867418L;
}
