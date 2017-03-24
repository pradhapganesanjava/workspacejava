package com.pg.java.string;

public class StringCompare {

	public static void main(String[] args) {
		//compareTo return int 0 eq; 1 grt; -1 less;
		compareToReturnIntMean();

	}

	private static void compareToReturnIntMean() {
		System.out.println("A == A compareTo returns "+"A".compareTo("A"));
		System.out.println("A < B compareTo returns " +"A".compareTo("B"));
		System.out.println("B > A compareTo returns " +"B".compareTo("A"));
		
		System.out.println("1 == 1 compareTo returns "+new Integer(1).compareTo(new Integer(1)));
		System.out.println("1 < 2 compareTo returns " +new Integer(1).compareTo(new Integer(2)));
		System.out.println("2 > 1 compareTo returns " +new Integer(2).compareTo(new Integer(1)));
	}

}
