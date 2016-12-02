package com.pg.java8.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class HelloLamda {

	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);

		//Internal Loop - sending consumer to loop by internal
		intList.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println("int : " + t);
			}
		});

		
		// Lamda rule: if an interface has only one method then simply invoke
		// body of the method by passing parameters; 
		// totally new to Java - an variable can be declared without mention about its type
		//
		intList.forEach(intWrap->System.out.println(intWrap));
	}

}
