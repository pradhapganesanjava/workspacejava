package com.pg.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

 /*
  * Lambda expression means:
  * 	Lambda expression contains two parts
  * 	 1) variable that points to implementation
  * 	 2) the implementation uses the variable
 	> Internal method knows, what's parameter type (FUNCTIONAL INTERFACE) it takes, so it skips to create instance; 
 	> body of the method by passing parameters; 
 	> totally new to Java - an variable can be declared without mention about its type
 */
public class Lambda_forEach {

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

		//Anonymoun with Lambda
		Consumer<Integer> intConsum = (Integer intVal) -> System.out.println("Anonymoun with Lambda " +intVal);
		intList.forEach(intConsum);
		
		//Lambda expression for internal loop forEach
		//forEach internal loop assign every value into variable, and use the variable later.
		intList.forEach(intWrap->System.out.println(intWrap));
		
		//Lambda expression with simple method call delegation
		intList.forEach(i->Lambda_forEach.simpleMethod(i));


		Integer intWrap = 100;
		System.out.println(" intWrap "+ intWrap);
	}
	
	private static void simpleMethod(Integer i){
		System.out.println(" "+ i);
	}
}

class ConsumerImpl implements Consumer<Integer>{
	@Override
	public void accept(Integer t) {
		System.out.println("ConsumerImpl "+t);
	}
}
