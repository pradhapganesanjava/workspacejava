package com.pg.java.xml.jaxb.topojo;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

public class TListXmlAdapterTest {

	public static void main(String[] args) {

		//toPojo("account1.xml");
		toPojoExt("accounts-root.xml");
		 //toXml();

	}

	private static void toPojo(String string) {
		Unmarshaller unm = unMarshall(new TListWrap());
		try {
			ListMapWrap rt = (ListMapWrap) unm.unmarshal(getFile(string));
			System.out.println(" rt " + rt);
			if (null != rt && null != rt.getItems()) {
				for (MapWrap<String, Object> gw : rt.getItems()) {
					System.err.println(gw.keySet());
					System.err.println(gw.values());
				}
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
	
	private static void toPojoExt(String fileSrc){

		try {
			//TListWrap<TMapWrap> rt = (TListWrap<TMapWrap>) unMarshallExt(fileSrc);
			List<TMapWrap<String, Object>> rt = unMarshallT(fileSrc);
			
			System.out.println(" rt " + rt);
			if (null != rt) {
				for (TMapWrap<String, Object> gw : rt) {
					System.err.println(gw.keySet());
					System.err.println(gw.values());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

			
	}

	private static void toXml() {
		TListWrap mpl = loadPojo();
		marshall(mpl);
	}

	public static void marshall(TListWrap mpl) {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(TMapWrap.class, TListWrap.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshaller.setAdapter(new TListXmlAdapter());

			QName qName = new QName("Accounts");
			JAXBElement<TListWrap> je = new JAXBElement(qName, TListWrap.class, mpl);
			
			marshaller.marshal(mpl, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static TListWrap unMarshallExt(String fileSrc) {

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(com.pg.java.xml.jaxb.topojo.TListWrap.class, com.pg.java.xml.jaxb.topojo.TMapWrap.class);

			Unmarshaller unm = jaxbContext.createUnmarshaller();
			unm.setAdapter(new TListXmlAdapter());
			StreamSource ssrc = new StreamSource(getFile(fileSrc));
			TListWrap rt = (TListWrap) unm.unmarshal(ssrc,TListWrap.class).getValue();
			
			return rt;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<TMapWrap<String, Object>> unMarshallT(String fileSrc) {

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(TListWrap.class, TMapWrap.class);

			Unmarshaller unm = jaxbContext.createUnmarshaller();
			unm.setAdapter(new TListXmlAdapter());
			StreamSource ssrc = new StreamSource(getFile(fileSrc));
			TListWrap rt = (TListWrap) unm.unmarshal(ssrc,TListWrap.class).getValue();
			
			return rt.getItems();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	private static Unmarshaller unMarshall(Object object) {

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

			Unmarshaller unm = jaxbContext.createUnmarshaller();
			unm.setAdapter(new TListXmlAdapter());
			return unm;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static File getFile(String fileSrc) {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			URL fUrl = classLoader.getResource(fileSrc);

			System.out.println(" furl file " + fUrl.toURI());

			URI fUri = fUrl.toURI();
			File file = new File(fUri);

			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static TListWrap loadPojo() {
		TMapWrap mp = new TMapWrap<String, Object>();

		TMapWrap actMp1 = new TMapWrap<String, Object>();
		actMp1.put("ActId", "111111");
		actMp1.put("ActType", "13706");
		actMp1.put("ActOwnerCd", "13706");

		TMapWrap actMp2 = new TMapWrap<String, Object>();
		actMp2.put("ActId", "222222");
		actMp2.put("ActType", "222222");
		actMp2.put("ActOwnerCd", "222222");

		TMapWrap actMp3 = new TMapWrap<String, Object>();
		actMp3.put("ActId", "333333");
		actMp3.put("ActType", "33333");
		actMp3.put("ActOwnerCd", "33");

		List<TMapWrap<String, Object>> actsLst = new ArrayList<TMapWrap<String, Object>>();

		actsLst.add(actMp1);
		actsLst.add(actMp2);
		actsLst.add(actMp3);

		TListWrap lstMap = new TListWrap();
		lstMap.setItems(actsLst);
		return lstMap;
	}
}
