package com.pg.ds.map;

import java.util.EnumMap;
import java.util.Iterator;

public class Hello_EnumMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//takes Enum as key
		//NO null keys permitted; NOT synchronized; 
		// NOT iterator fail fast; - means during iteration the map can be modified by same or other thread.
		//
		
		EnumMap<HelloEnum, Object> enumMap = new EnumMap<HelloEnum, Object>(Hello_EnumMap.HelloEnum.class);
		enumMap.put(HelloEnum.HELLO_ONE,"one");
		enumMap.put(HelloEnum.HELLO_TWO,"two");
		
		for(Iterator<HelloEnum> enumItr=enumMap.keySet().iterator();enumItr.hasNext();){
			HelloEnum enumKey = enumItr.next();
			System.out.println(enumKey+":"+enumMap.get(enumKey));
			enumMap.put(HelloEnum.HELLO_THREE, "three");
		}
		

	}
	
	enum HelloEnum{
		HELLO_ONE, HELLO_TWO, HELLO_THREE
	}

}
