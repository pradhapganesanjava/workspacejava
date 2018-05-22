package com.pg.java.xml.jaxb.topojo.rowmap;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class JaxbMapXmlApp {

	public static void main(String... str) {

		try {

			JAXBContext jc = JAXBContext.newInstance(RowPojo.class);
			RowMapXmlAdapter adapter = new RowMapXmlAdapter();

			Unmarshaller um = jc.createUnmarshaller();
			um.setAdapter(adapter);
			toXml(jc, adapter);
			//toPojo(um);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	private static void toPojo(Unmarshaller um) throws JAXBException {
		RowPojo r = (RowPojo)um.unmarshal(getFile("rowmap.xml"));
		System.err.println(r.toString());
	}
	
	private static void toXml(JAXBContext jc, RowMapXmlAdapter adapter) throws JAXBException, PropertyException {
		RowPojo  mpLst = new RowPojo ();
		//List<Map<String, String>> mpLst = new ArrayList<Map<String,String>>();
		 
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("ActId", "11111");
		mp.put("ActType", "AAAA");
		
		Map<String, String> mp2 = new HashMap<String, String>();
		mp2.put("ActId", "11111");
		mp2.put("ActType", "AAAA");
		
		mpLst.add(mp);
		mpLst.add(mp2);
		
		//r.setMpLst(mpLst);

		Marshaller m = jc.createMarshaller();
		m.setAdapter(adapter);
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(mpLst, System.out);
	}

	/*
	private static void toXml(JAXBContext jc, RowMapXmlAdapter adapter) throws JAXBException, PropertyException {
		RowPojo r = new RowPojo();
		List<Map<String, String>> mpLst = new ArrayList<Map<String,String>>();
		 
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("ActId", "11111");
		mp.put("ActType", "AAAA");
		
		Map<String, String> mp2 = new HashMap<String, String>();
		mp2.put("ActId", "11111");
		mp2.put("ActType", "AAAA");
		
		mpLst.add(mp);
		mpLst.add(mp2);
		
		r.setMpLst(mpLst);

		Marshaller m = jc.createMarshaller();
		m.setAdapter(adapter);
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(r, System.out);
	}
	*/

	private static File getFile(String fileSrc) {

		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			URL fUrl = classLoader.getResource(fileSrc);

			System.out.println(" furl file " + fUrl.toURI());
			File file = new File(fUrl.toURI());
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
