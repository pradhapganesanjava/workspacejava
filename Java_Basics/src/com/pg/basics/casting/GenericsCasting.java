package com.pg.basics.casting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GenericsCasting {

	public static void main(String str[]){
		
		List<String> strList = new ArrayList<String>(); 
		List<String> arrStrList = Arrays.asList("green","yello");
		Collection<String> collStrList = strList;
		ArrayList<String> arrList = (ArrayList<String>)strList;
		
	}
	
}
