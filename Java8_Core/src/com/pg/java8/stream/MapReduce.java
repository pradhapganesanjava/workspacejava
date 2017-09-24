package com.pg.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class MapReduce {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("A_", "B_", "C_","D","E","Z_");

		//implementing Function.apply will have more control of map
		Function<String, String> funcStr = new Function<String, String>() {
			@Override
			public String apply(String str) {
				if (str.contains("_")) {
					return str + "X";
				} else {
					return str;
				}
			}
		};
		
		//Just map
		Stream<String> streaMap = strList.stream().map(i -> i + "X");
		System.out.println("Stream Map : "+streaMap.toArray());
		
		//apply map only string
		strList.stream().map(funcStr).forEach(i -> System.out.println(i));

		// map - each item in the list maps the changes
		strList.stream().map(i -> i + "X").forEach(i -> System.out.println(i));

		// map + reduce - apply calculus logic and return a value
		System.out.println(strList.stream().map(i -> i + "X").reduce((c, e) -> c + "," + e).get());
	}
	
	private static List<String> shrinkListStr(){
		return null;
	}

}
