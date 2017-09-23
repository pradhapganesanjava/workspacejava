package com.pg.java.util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerUtil {

	public static void main(String[] args) {
		String sourceStr = "sentence, with, lots, of, commas.!  "
		        + "(And some poaren)).  The output is: 7.5.";
		
		Scanner scanner  = new Scanner(sourceStr).useDelimiter(Pattern.compile("[^a-zA-Z]+"));
		System.out.println("1" +scanner.next());
		while(scanner.hasNext()){
			System.out.println(scanner.next());
		}
		

	}

}
