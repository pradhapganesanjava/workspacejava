package com.pg.java.xml.jaxb.topojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ListXmlAdapter extends XmlAdapter<ListXmlAdapter.ListXmlAdapterEl, MapWrap<String, Object>> {

	public static class ListXmlAdapterEl {
		@XmlAnyElement
		public List<Element> elist = new ArrayList<Element>();
	}

	@Override
	public ListXmlAdapterEl marshal(MapWrap<String, Object> mpl) throws Exception {
		ListXmlAdapterEl mpv = new ListXmlAdapterEl();

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
	public MapWrap<String, Object> unmarshal(ListXmlAdapterEl mpv) throws Exception {
		MapWrap<String, Object> gw = new MapWrap<String, Object>();
		for(Element e : mpv.elist){
			gw.put(e.getLocalName(), e.getTextContent());
			System.out.println(e.getLocalName()+" : " + e.getTextContent());
		}
		return gw;
	}

}
