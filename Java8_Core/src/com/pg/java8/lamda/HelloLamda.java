package com.pg.java8.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

 /*
  * Lamda expression means:
  * 	Lamda expression contains two parts
  * 	 1) variable that points to implementation
  * 	 2) the implementation uses the variable
 	> Internal method knows, what's parameter type (FUNCTIONAL INTERFACE) it takes, so it skips to create instance; 
 	> body of the method by passing parameters; 
 	> totally new to Java - an variable can be declared without mention about its type
 */
public class HelloLamda {

	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);

		//Legacy expression for internal loop forEach
		intList.forEach(new ConsumerImpl());
		
		//Anonymous expression for internal loop forEach
		intList.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println("Anonymous : " + t);
			}
		});

		//Anonymoun with Lamda
		Consumer<Integer> intConsum = (Integer intVal) -> System.out.println("Anonymoun with Lamda " +intVal);
		intList.forEach(intConsum);
		
		//Lamda expression for internal loop forEach
		//forEach internal loop assign every value into variable, and use the variable later.
		intList.forEach(intWrap->System.out.println(intWrap));

		Integer intWrap = 100;
		System.out.println(" intWrap "+ intWrap);
	}
}

class ConsumerImpl implements Consumer<Integer>{
	@Override
	public void accept(Integer t) {
		System.out.println("ConsumerImpl "+t);
	}
}