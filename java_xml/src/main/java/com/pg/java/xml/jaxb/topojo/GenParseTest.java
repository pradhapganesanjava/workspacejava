package com.pg.java.xml.jaxb.topojo;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class GenParseTest {

	public static void main(String[] args) throws ParseException {
		 toXml();
		//toPojo();

	}

	private static void toPojo() {
		Unmarshaller unm = unMarshall(new GenRoot());
		try {
			GenRoot rt = (GenRoot) unm.unmarshal(getFile("account1.xml"));
			System.out.println(" rt " + rt);
			if (null != rt && null != rt.getMpr()) {
				GenMapWrap<String, Object> gw = rt.getMpr();
				System.err.println(gw.keySet());
				System.err.println(gw.values());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	private static void toXml() throws ParseException {
		GenRoot rt = new GenRoot();
		GenMapWrap<String, Object> gw = new GenMapWrap<String, Object>();
		gw.put("ActId", "13706");
		gw.put("ActType", "13706");
		gw.put("ActOwnerCd", "13706");
		gw.put("FirmCd", "01");
		gw.put("ImsNum", "03165891");
		gw.put("LastTradeDt", new SimpleDateFormat("mm-dd-yyyy").parse("01-01-2000"));
		gw.put("Mnemonic", "ST13400");
		gw.put("PrimeLoc", "Tampa");
		gw.put("UsPersonFlg", false);

		rt.setMpr(gw);

		marshall(rt);
	}

	public static void marshall(Object object) {

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

			Marshaller marshaller = jaxbContext.createMarshaller();

			marshaller.setAdapter(new GenMapXmlAdapter());
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshaller.marshal(object, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static Unmarshaller unMarshall(Object object) {

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

			Unmarshaller unm = jaxbContext.createUnmarshaller();
			unm.setAdapter(new GenMapXmlAdapter());
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
}
