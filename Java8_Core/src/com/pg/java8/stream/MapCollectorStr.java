package com.pg.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapCollectorStr {

	static String[] strArr = {"A","B","C","D"}; 
	
	public static void main(String[] args) {
		List<String> strLst = new ArrayList<>(Arrays.asList(strArr));
		List<String> strTagLst = strLst.stream().sequential().map(str -> "<"+str+">").collect(Collectors.toList());
		
		strTagLst.forEach(e -> System.out.println(e));
		
		
	}
}