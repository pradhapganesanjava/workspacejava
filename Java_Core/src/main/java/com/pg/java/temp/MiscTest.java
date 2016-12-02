package com.pg.java.temp;

import java.util.Arrays;
import java.util.List;

public class MiscTest {

	public static void main(String[] args) {
		squareRoot();

		List lst = Arrays.asList(new String[] { "a", "b", "c" });
		System.out.println(" contains " + lst.contains("a"));

		System.out.println(" " + (float) 5 / 4);
	}

	private static void squareRoot() {
		System.out.println("sqroot  " + Math.pow(4, 0.5));
		System.out.println("sqroot  " + Math.sqrt(4));
	}

}
