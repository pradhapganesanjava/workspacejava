package com.pg.java.xml.jaxb.topojo.wrap.cust;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MXmlAdapter extends XmlAdapter<MXmlAdapter.ListXmlAdapterEl, MWrap<String, String>> {

	public static class ListXmlAdapterEl {
		//@XmlAnyElement
		public List<Element> elist = new ArrayList<Element>();
	}

	@Override
	public ListXmlAdapterEl marshal(MWrap<String, String> mpl) throws Exception {
		ListXmlAdapterEl mpv = new ListXmlAdapterEl();

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		List<Element> elist = new ArrayList<Element>();
		
		for(String k : mpl.keySet()){
			Element e = doc.createElement(k);
			e.setTextContent(mpl.get(k).toString());
			elist.add(e);
		}
		
		mpv.elist = elist; 
		return mpv;
	}

	@Override
	public MWrap<String, String> unmarshal(ListXmlAdapterEl mpv) throws Exception {
		MWrap<String, String> gw = new MWrap<String, String>();
		for(Element e : mpv.elist){
			gw.put(e.getLocalName(), e.getTextContent());
			System.out.println(e.getLocalName()+" : " + e.getTextContent());
		}
		return gw;
	}

}
