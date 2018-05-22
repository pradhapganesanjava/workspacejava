package com.pg.java.xml.jaxb.topojo.rowmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RowMapXmlAdapter extends XmlAdapter<RowMapXmlAdapter.AdaptedMap, RowPojo>{

	RowPojo mpLst = new RowPojo();
	
	public static class AdaptedMap{
		@XmlAnyElement
		public List<Element> elems = new ArrayList<Element>();
	}
	@Override
	public AdaptedMap marshal(RowPojo mapLst) throws Exception {
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		AdaptedMap adaptedMap = new AdaptedMap();
		
		for(Map<String, String> mapIn : mapLst ){
			Element e = doc.createElement("ROW");
			
			for(Entry<String, String> entry : mapIn.entrySet()){
				Element ie = doc.createElement(entry.getKey());
				ie.setTextContent(entry.getValue());
				e.appendChild(ie);
			}
			adaptedMap.elems.add(e);			
		}
		return adaptedMap;
	}
	/*
	@Override
	public AdaptedMap marshal(List<Map<String, String>> mapLst) throws Exception {
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		AdaptedMap adaptedMap = new AdaptedMap();
		
		for(Map<String, String> mapIn : mapLst ){
			Element e = doc.createElement("ROW");
			
			for(Entry<String, String> entry : mapIn.entrySet()){
				Element ie = doc.createElement(entry.getKey());
				ie.setTextContent(entry.getValue());
				e.appendChild(ie);
			}
			adaptedMap.elems.add(e);			
		}
		return adaptedMap;
	}
	*/
	
	/*@Override
	public AdaptedMap marshal(List<Map<String, String>> mapLst) throws Exception {
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		AdaptedMap adaptedMap = new AdaptedMap();
		
		for(Map<String, String> mapIn : mapLst ){
			for(Entry<String, String> entry : mapIn.entrySet()){
				Element ie = doc.createElement(entry.getKey());
				ie.setTextContent(entry.getValue());
				adaptedMap.elems.add(ie);
			}
						
		}
		return adaptedMap;
	}*/	
	/*
	@Override
	public AdaptedMap marshal(Map<String, String> mapIn) throws Exception {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		AdaptedMap adaptedMap = new AdaptedMap();
		for(Entry<String, String> entry : mapIn.entrySet()){
			Element elem = doc.createElement(entry.getKey());
					elem.setTextContent(entry.getValue());
					adaptedMap.elems.add(elem);
		}
		
		return adaptedMap;
	}

	@Override
	public Map<String, String> unmarshal(AdaptedMap amp) throws Exception {
		Map<String, String> mp = new HashMap<String, String>();
		for(Element e : amp.elems){
			System.out.println(e.getLocalName()+" : "+e.getTextContent());
			mp.put(e.getLocalName(), e.getTextContent());
		}
		return mp;
	}*/

	@Override
	public RowPojo unmarshal(AdaptedMap amp) throws Exception {
		Map<String, String> mp = new HashMap<String, String>();
		for(Element e : amp.elems){
			System.out.println(e.getLocalName()+" : "+e.getTextContent());
			mp.put(e.getLocalName(), e.getTextContent());
		}
		mpLst.add(mp);
		return mpLst;
	}
}
