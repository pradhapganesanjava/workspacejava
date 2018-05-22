package com.pg.java.xml.jaxb.topojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TListXmlAdapter extends XmlAdapter<TListXmlAdapter.TListXmlAdapterEl, TMapWrap<String, Object>> {

	public static class TListXmlAdapterEl {
		//@XmlAnyElement
		public List<Element> elist = new ArrayList<Element>();
	}

	@Override
	public TListXmlAdapterEl marshal(TMapWrap<String, Object> mpl) throws Exception {
		TListXmlAdapterEl mpv = new TListXmlAdapterEl();

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
	public TMapWrap<String, Object> unmarshal(TListXmlAdapterEl mpv) throws Exception {
		TMapWrap<String, Object> gw = new TMapWrap<String, Object>();
		for(Element e : mpv.elist){
			System.out.println(e.getLocalName()+" : "+e.getTextContent());
			gw.put(e.getLocalName(), e.getTextContent());
		}
		return gw;
	}

}
