package com.pg.java.xml.jaxb.topojo.rowmap;

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

public class MapXmlAdapterTest {

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

		try {
			//ListMapWrap rt = (ListMapWrap) unm.unmarshal(getFile(fsrc));
			MapWrapper rt = unmarshallToPojo(fsrc);			
			
			System.out.println(" rt " + rt);
			if (null != rt && null != rt.getItems()) {
				for (MapXml<String, Object> gw : rt.getItems()) {
					System.err.println(gw.keySet());
					System.err.println(gw.values());
				}
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}



	private static MapWrapper unmarshallToPojo(String fsrc) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(MapWrapper.class);

		Unmarshaller unm = jaxbContext.createUnmarshaller();
		unm.setAdapter(new MapXmlAdapter());
		
		StreamSource xmlSource = new StreamSource(getFile(fsrc));
		JAXBElement<MapWrapper> jaxbElement = unm.unmarshal(xmlSource, MapWrapper.class);
		
		MapWrapper rt = jaxbElement.getValue();
		return rt;
	}

	private static void toXml() {
		MapWrapper mpl = loadPojo();
		marshall(mpl);
	}

	public static void marshall(MapWrapper object) {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(MapWrapper.class, MapXml.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshaller.setAdapter(new MapXmlAdapter());

	        QName qName = new QName("Accounts");
	        JAXBElement<MapWrapper> je = new JAXBElement<MapWrapper>(qName,
	        		MapWrapper.class, object);
			
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
			unm.setAdapter(new MapXmlAdapter());
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

	private static MapWrapper loadPojo() {
		MapXml mp = new MapXml<String, Object>();

		MapXml actMp1 = new MapXml<String, Object>();
		actMp1.put("ActId", "111111");
		actMp1.put("ActType", "13706");
		actMp1.put("ActOwnerCd", "13706");

		MapXml actMp2 = new MapXml<String, Object>();
		actMp2.put("ActId", "222222");
		actMp2.put("ActType", "222222");
		actMp2.put("ActOwnerCd", "222222");

		MapXml actMp3 = new MapXml<String, Object>();
		actMp3.put("ActId", "333333");
		actMp3.put("ActType", "33333");
		actMp3.put("ActOwnerCd", "33");

		List<MapXml<String, Object>> actsLst = new ArrayList<MapXml<String, Object>>();

		actsLst.add(actMp1);
		actsLst.add(actMp2);
		actsLst.add(actMp3);

		MapWrapper lstMap = new MapWrapper();
		lstMap.setItems(actsLst);
		return lstMap;
	}
}
