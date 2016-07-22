package com.pg.java.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExMatchString {

	static String str = "";
	String strNonStatic = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		str = "HIIII, HI HOW OLD ARE YOU?; hi how old are you?.   I Am in 30s.";
 String str2 = "this is a test23,54,390.";
		//RegExMatchString.Tokens token = new RegExMatchString.Tokens();

		//System.out.println(" " + Arrays.toString(token.getTokens(",").toArray()));
		System.out.println(" " + Arrays.toString(getTokens("[^.?]+",str).toArray()));
		System.out.println(" " + Arrays.toString(getTokens("[^.,]+",str2).toArray()));
		System.out.println("[a-z ]+|[0-9]+ " + Arrays.toString(getTokens("[a-z ]+|[0-9]+",str2).toArray()));
		System.out.println("[a-z0-9 ]+ :" + Arrays.toString(getTokens("[a-z0-9 ]+",str2).toArray()));
		System.out.println("[a-z0-9 ]+ :" + Arrays.toString(getTokens("[^.,?;:\"\' ]+",str).toArray()));
		
		//inlineBasicRegEx();
	}

	private static void inlineBasicRegEx() {
		System.out.println(" " + Arrays.toString(str.split(" +")));
		System.out.println(" " + Arrays.toString(str.split("HI*|hi")));
		System.out.println(" " + Arrays.toString(str.split("H|h")));
		System.out.println(" " + Arrays.toString(str.split("[Hh]")));

		System.out.println(" " + Arrays.toString("1 2 33".split("[1-3]*")));
		System.out.println(" " + Arrays.toString("1 2 33".split("1|2|33")));
		System.out.println(" " + Arrays.toString("1 2 33".split("[0-9]+")));

		System.out.println(" " + Arrays.toString(str.split("[a-zA-Z]+")));

		System.out.println(" " + Arrays.toString(str.split("[^.?]+")));

		System.out.println(Arrays.toString("this is a test.23 ,54 ,390.".split("[a-z0-9 ]+")));
	}

	static List<String> getTokens(String pattern, String doc)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(doc);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		
		return tokens;
	}
	
	private static class Tokens {
		String string = str;
		String nonStatic = new RegExMatchString().strNonStatic;

		/*
		 * public Tokens(String str) { string = str; }
		 */
		public List<String> getTokens(String pattern) {
			List<String> str = new ArrayList<String>();
			Pattern patternObj = Pattern.compile(pattern);
			Matcher match = patternObj.matcher(string);
			int count = 0;
			while (match.find()) {
				System.out.println(" match.group() "+match.group());
				str.add(match.group());
				count++;
			}
			return str;
		}
	}
}
