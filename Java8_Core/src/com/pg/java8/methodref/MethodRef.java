package com.pg.java8.methodref;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.List;

/*
 * Before Java8 there were PASS BY VALUE, PASS BY REFERENCE
 * now, We have PASS BY METHOD REFERENCE 
 * pass by method reference uses new syntax ::
 * 
 */
public class MethodRef {

	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(1,2,3,4);
		
		//instead of calling the method, reference is passed to other method (forEach)
		intList.forEach(PassByMethodRef::myMethod);
		
		//any method reference can be passed, to consumer method parameter.
		intList.forEach(System.out::println);
		
		new MethodRef().intSqur(MethodRef::myMethod);
		
	}

	public static void myMethod(Integer i) {
		System.out.println("myMethod is called :: " + i);
	}
	
	public static void intSqur(IntConsumer intConsum)
	{
		int i=0;
		intConsum.accept(i);
	}
}

class PassByMethodRef {

	public static void myMethod(int i) {
		System.out.println("myMethod is called :: " + i);
	}
}
