package com.pg.java.xml.jaxb.topojo.rowmap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MapXmlAdapter extends XmlAdapter<MapXmlAdapter.ListXmlAdapterEl, MapXml<String, Object>> {

	public static class ListXmlAdapterEl {
		@XmlAnyElement
		public List<Element> elist = new ArrayList<Element>();
	}

	@Override
	public ListXmlAdapterEl marshal(MapXml<String, Object> mpl) throws Exception {
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
	public MapXml<String, Object> unmarshal(ListXmlAdapterEl mpv) throws Exception {
		MapXml<String, Object> gw = new MapXml<String, Object>();
		for(Element e : mpv.elist){
			gw.put(e.getLocalName(), e.getTextContent());
			System.err.println(e.getLocalName()+" : " + e.getTextContent());
		}
		return gw;
	}

}
