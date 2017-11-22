package com.pg.java8.pattern.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IterartorPatternJ8 {

	public static void main(String[] args) {

		
		List<Integer> intList = new ArrayList<>(Arrays.asList(11,19,20,22));
		//Legacy Iterator
		for(int i=0; i<intList.size();i++){
			System.out.println("dec "+intList.get(i));
		}
		
		//foreach imperative 
		for(int i : intList){
			System.out.println("imp "+i);
		}
		
		//forEach declarative
		intList.forEach(System.out::println);
		intList.forEach(x -> System.out.println("lamb "+x));
	}

}
