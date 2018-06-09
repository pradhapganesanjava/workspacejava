package com.pg.java.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTokenUtil {
	
	public static void main(String...str){
		String strtxt = "CLIENT|CLIENT FUND CODE|DATA FEED|TRADE DATE|PRODUCT CATEGORY|SUB PRODUCT CATEGORY|DIRECTION|QUANTITY";
		List<String> strLst = getTokens(strtxt, "|");
		//strLst.forEach( s -> System.out.print(s));
		
		Scanner scanner  = new Scanner(strtxt).useDelimiter(Pattern.compile(overrideDelimiter("|")));
		//System.out.println("1" +scanner.next());
		while(scanner.hasNext()){
			System.err.println(scanner.next());
		}
		
		System.out.println(overrideDelimiter(","));
		System.out.println(overrideDelimiter("|"));
		System.out.println(overrideDelimiter("\\t"));
	}

	static List<String> getTokens(String pattern, String doc) {
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(doc);

		while (m.find()) {
			tokens.add(m.group());
		}

		return tokens;
	}
	
	private static String overrideDelimiter(String delimit) {
		switch(delimit) {
			case "|":
				return "\\|";
			case "\\t":
				return "\t";
			default:
				return delimit;
		}
	}
}
