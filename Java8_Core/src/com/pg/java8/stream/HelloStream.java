package com.pg.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class HelloStream {

	public static void main(String[] args) {

		List<String> lst = new ArrayList<>(Arrays.asList("aaa","bbb","ccc","ddd","eee"));
		Stream lstStream = lst.stream();
		
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;
		int z = x + y;
		System.out.println(z);
		z = Math.addExact(x, y);
		System.out.println(z);
		
	}

}
