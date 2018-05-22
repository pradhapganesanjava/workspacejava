package com.pg.java.xml.jaxb.topojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GenMapXmlAdapter extends XmlAdapter<GenMapXmlAdapter.GenMapXmlAdapterVal, GenMapWrap<String, Object>> {

	public static class GenMapXmlAdapterVal {
		@XmlAnyElement
		public List<Element> elist = new ArrayList<Element>();
	}

	@Override
	public GenMapXmlAdapterVal marshal(GenMapWrap<String, Object> mpl) throws Exception {
		GenMapXmlAdapterVal mpv = new GenMapXmlAdapterVal();

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		List<Element> elist = new ArrayList<Element>();
		
		for(String k : mpl.keySet()){
			Element e = doc.createElement(k);
			if(! (mpl.get(k) instanceof List)){
				e.setTextContent(mpl.get(k).toString());
			}
			elist.add(e);
		}
		
		mpv.elist = elist; 
		return mpv;
	}

	@Override
	public GenMapWrap<String, Object> unmarshal(GenMapXmlAdapterVal mpv) throws Exception {
		GenMapWrap<String, Object> gw = new GenMapWrap<String, Object>();
		for(Element e : mpv.elist){
			gw.put(e.getLocalName(), e.getTextContent());
		}
		return gw;
	}

}
