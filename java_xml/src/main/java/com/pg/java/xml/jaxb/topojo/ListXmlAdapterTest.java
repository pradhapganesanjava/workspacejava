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

public class ListXmlAdapterTest {

	public static void main(String[] args) {
		
        /*AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(MapBeanConfig.class);
        	//ClientBean bean = context.getBean(MapBeanConfig.class);		

		System.out.println(new ListXmlAdapterTest().mps.keySet());*/
		
		//toPojo("account1.xml");
		toPojo("accounts-root.xml");
		//toXml();

	}
	


	private static void toPojo(String fsrc) {
		Unmarshaller unm = unMarshall(new ListMapWrap());
		try {
			//ListMapWrap rt = (ListMapWrap) unm.unmarshal(getFile(fsrc));
			
			StreamSource xmlSource = new StreamSource(getFile(fsrc));
			JAXBElement<ListMapWrap> jaxbElement = unm.unmarshal(xmlSource, ListMapWrap.class);
			ListMapWrap rt = jaxbElement.getValue();			
			
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

	private static void toXml() {
		ListMapWrap mpl = loadPojo();
		marshall(mpl);
	}

	public static void marshall(ListMapWrap object) {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(ListMapWrap.class, MapWrap.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshaller.setAdapter(new ListXmlAdapter());

	        QName qName = new QName("Accounts");
	        JAXBElement<ListMapWrap> je = new JAXBElement<ListMapWrap>(qName,
	        		ListMapWrap.class, object);
			
			//marshaller.marshal(object, System.out);
	        marshaller.marshal(je, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static Unmarshaller unMarshall(Object object) {

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

			Unmarshaller unm = jaxbContext.createUnmarshaller();
			unm.setAdapter(new ListXmlAdapter());
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

	private static ListMapWrap loadPojo() {
		MapWrap mp = new MapWrap<String, Object>();

		MapWrap actMp1 = new MapWrap<String, Object>();
		actMp1.put("ActId", "111111");
		actMp1.put("ActType", "13706");
		actMp1.put("ActOwnerCd", "13706");

		MapWrap actMp2 = new MapWrap<String, Object>();
		actMp2.put("ActId", "222222");
		actMp2.put("ActType", "222222");
		actMp2.put("ActOwnerCd", "222222");

		MapWrap actMp3 = new MapWrap<String, Object>();
		actMp3.put("ActId", "333333");
		actMp3.put("ActType", "33333");
		actMp3.put("ActOwnerCd", "33");

		List<MapWrap<String, Object>> actsLst = new ArrayList<MapWrap<String, Object>>();

		actsLst.add(actMp1);
		actsLst.add(actMp2);
		actsLst.add(actMp3);

		ListMapWrap lstMap = new ListMapWrap();
		lstMap.setItems(actsLst);
		return lstMap;
	}
}
