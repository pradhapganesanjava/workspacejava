package com.pg.java.xml.vtd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.ximpleware.EOFException;
import com.ximpleware.EncodingException;
import com.ximpleware.EntityException;
import com.ximpleware.NavException;
import com.ximpleware.ParseException;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;

public class XmlVtdHello {

	public static void main(String[] args)
			throws IOException, EncodingException, EOFException, EntityException, ParseException, NavException, URISyntaxException {

		File file = getFile("purchase.xml");

		FileInputStream fins = new FileInputStream(file);
		byte[] ba = new byte[(int) file.length()];

		fins.read(ba);

		VTDGen vg = new VTDGen();

		vg.setDoc(ba);
		vg.parse(false);

		 
         VTDNav vn = vg.getNav();
         if (vn.matchElement("purchaseOrder")){
             System.out.println(" orderDate==>" 
                 + vn.toString(vn.getAttrVal("orderDate")));
             if (vn.toElement(VTDNav.FIRST_CHILD,"item")){
                 if (vn.toElement(VTDNav.FIRST_CHILD)){
                     do {
                         System.out.print( vn.toString(vn.getCurrentIndex()));
                             System.out.print("==>");
                         System.out.println( vn.toString(vn.getText()));
                     } while(vn.toElement(VTDNav.NEXT_SIBLING));
                 }
             }
         }
         
//		customVers(vg);

	}

	private static File getFile(String fileSrc) throws URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL fUrl = classLoader.getResource(fileSrc);

		System.out.println(" furl file " + fUrl.toURI());
		
		URI fUri = fUrl.toURI();
		File file = new File(fUri);

		return file;
	}

	private static void customVers(VTDGen vg) throws NavException {
		VTDNav vn = vg.getNav();

		System.out.println(vn.matchElement("purchaseOrder"));
		System.out.println(vn.toString(vn.getAttrVal("orderDate")));
		System.out.println(vn.toElement(VTDNav.FIRST_CHILD));
		System.out.println(vn.toString(vn.getCurrentIndex()));
		System.out.println(vn.toString(vn.getText()));
		while (vn.toElement(VTDNav.NEXT_SIBLING)) {
			System.out.println(vn.toString(vn.getCurrentIndex()));
			System.out.println(vn.toString(vn.getText()));
		}
	}

}
