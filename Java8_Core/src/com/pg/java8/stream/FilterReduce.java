package com.pg.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterReduce {

	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(12, 13, 15, 20, 22, 25, 30, 33, 40, 44);

		// print all integers divisible by 5
		// Legacy way - print all integers divisible by 5
		for (int i : intList) {
			if (i % 5 == 0) {
				System.out.println(" " + i);
			}
		}

		// Lamda pass - print all integers divisible by 5
		// Not able to do anything on the result
		intList.forEach(i ->printApplyMod(i));
		
		// MethodRef pass - print all integers divisible by 5
		// Not able to do anything on the result
		intList.forEach(FilterReduce::applyMod);
		
		// Stream uses Predicate anonymous- print all integers divisible by 5
		Predicate<Integer> predicate = new Predicate<Integer>() {
			public boolean test(Integer t) {
				return t % 5 == 0;
			};
		};
		System.out.println("Predicate anonymous filtered...");
		intList.stream().filter(predicate).forEach(i->System.out.println(i));

		System.out.println("lamda filtered...");
		intList.stream().filter(i -> i%5==0).forEach(i->System.out.println(i));
	}

	private static int applyMod(int operant) {
//		System.out.println(" methodRef");
		if (operant % 5 == 0) {
			System.out.println(" "+operant);
			return operant;
		} else {
			return 0;
		}
	}
	
	private static void printApplyMod(int operant) {
			System.out.println(" "+operant);
	}


}
