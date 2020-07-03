package com.pg.java8.map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InitList {

	public static void main(String[] args) {
		List<Integer> ilst = new ArrayList<>(10);
		IntStream.range(0,10).map(i ->  ilst.add(i));
		ilst.stream().map(itm -> {
			return new Integer(1);
		});
		ilst.forEach(ech -> System.out.print(ech+","));
		
		

	}

}
