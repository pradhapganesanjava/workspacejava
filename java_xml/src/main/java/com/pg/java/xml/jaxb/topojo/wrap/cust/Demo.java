package com.pg.java.xml.jaxb.topojo.wrap.cust;

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

public class Demo {
	 
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Wrapper.class, Person.class,
                Address.class, MWrap.class, MWrapper.class);
 
        // Unmarshal
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        List<Address> addresses = unmarshal(unmarshaller, "addresses.xml");
        List<Person> persons = unmarshal(unmarshaller,  "persons.xml");
        
        for(Address ad : addresses){
        	System.out.println(ad.toString());
        }

        for(Person pr : persons){
        	System.out.println(pr.toString());
        }
        
        /*
        MWrap mw1 = new MWrap();
        Map<String, Object> mp1 = new HashMap<>();
        mp1.put("AccId", "AAAA");
        mw1.setmItem(mp1);
        
        MWrap mw2 = new MWrap();
        Map<String, Object> mp2 = new HashMap<>();
        mp2.put("AccId", "BBBB");
        mw2.setmItem(mp1);

        lmw.add(mw1);
        lmw.add(mw2);
        */
        List<MWrap<String, String>> lmw = new ArrayList<>();
        MWrap<String, String> mw1 = new MWrap<String, String>();
        mw1.put("AccId", "AAAA");
        
        MWrap<String, String> mw2 = new MWrap<String, String>();
        mw2.put("AccId", "BBBB");

        lmw.add(mw1);
        lmw.add(mw2);
        
        // Marshal
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshal(marshaller, lmw, "Accounts");
        
     }
 
    /**
     * Unmarshal XML to Wrapper and return List value.
     */
    private static <T> List<T> unmarshal(Unmarshaller unmarshaller, String xmlLocation) throws JAXBException {
        StreamSource xml = new StreamSource(getFile(xmlLocation));
        Wrapper<T> wrapper = (Wrapper<T>) unmarshaller.unmarshal(xml,
                Wrapper.class).getValue();
        return wrapper.getItems();
    }
 
    /**
     * Wrap List in Wrapper, then leverage JAXBElement to supply root element 
     * information.
     */
    /*private static void marshal(Marshaller marshaller, List<?> list, String name)
            throws JAXBException {
        QName qName = new QName(name);
        Wrapper wrapper = new Wrapper(list);
        JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName,
                Wrapper.class, wrapper);
        marshaller.marshal(jaxbElement, System.out);
    }*/
    
    private static void marshal(Marshaller marshaller, List<MWrap<String, String>> list, String name)
            throws JAXBException {
        QName qName = new QName(name);
        MWrapper wrapper = new MWrapper(list);
        JAXBElement<MWrapper> jaxbElement = new JAXBElement<MWrapper>(qName,
        		MWrapper.class, wrapper);
        marshaller.marshal(jaxbElement, System.out);
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
