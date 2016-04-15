package com.pg.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//filterXSS();
		//testStripNonDigits();
		testIsNumber();
	}

	private static boolean isNumber(String strInput){
		if("".equals(strInput))return false;
		
		return strInput.matches("^\\d+$");
	}
	
	private static void testIsNumber(){
		
		String str1 = " 00 1";
		String str2 = " 001 ";
		String str3 = "001";
		String str4 = "a001b";
		
		System.out.println(str1+" isNumber? "+isNumber(str1));
		System.out.println(str2+" isNumber? "+isNumber(str2));
		System.out.println(str3+" isNumber? "+isNumber(str3));
		System.out.println(str4+" isNumber? "+isNumber(str4));
	}
	
	private static void filterXSS() {
		String input = "/direct/CoverageMaps? app=NET10'A\"style=color:(+al ert (5948)+)! &lang=es";
		//String input = "/direct/CoverageMaps? app=NET10&lang=es'+alert(-'";
		String output = input;
		//(?i)[<>%\+]|(on.*\=)|(javascript)|(vbscript)|(expression)|(/\*.*\*/)|(//)|(['"];)|(&#)|(\);)|(://)|('\s*(and|or)*\s+.*--)
		String parameterPattern = "(?i)[<>%\\+]|(on.*\\=)|alert(\\s*)\\(|alert%28|(javascript)|(vbscript)|(expression)|(/\\*.*\\*/)|(//)|(['\"];)|(&#)|(\\);)|(://)|('\\s*(and|or)*\\s+.*--)";
		Pattern pattern = Pattern.compile(parameterPattern);

		// output = pattern.matcher(output).replaceAll(replacement);
		Matcher m = pattern.matcher(input);

		// while(m.find()){
		if (m.find()) {
			output = "";
			// output = m.replaceAll(replacement);
			// m=pattern.matcher(output);
		}
	}
	
	public static String stripNonDigits(String str){
		return str.replaceAll("[^0-9?]","");
	}
	
	public static void testStripNonDigits(){
		String str1 = "+123456789";
		String str2 = "123 456 7890";
		String str3 = "(123) 456-7890";
		String str4 = "123-456-0789";
		String str5 = " 123  456-0789";
		String str6 = "+1(123)-456 0789";
		String str7 = "..+1..(123).456.0789...";
		String str8 = "(+1)X(123)Y456Z0789...";
		
		System.out.println(str1 +" -->" + stripNonDigits(str1));
		System.out.println(str2 +" -->" + stripNonDigits(str2));
		System.out.println(str3 +" -->" + stripNonDigits(str3));
		System.out.println(str4 +" -->" + stripNonDigits(str4));
		System.out.println(str5 +" -->" + stripNonDigits(str5));
		System.out.println(str6 +" -->" + stripNonDigits(str6));
		System.out.println(str7 +" -->" + stripNonDigits(str7));
		System.out.println(str8 +" -->" + stripNonDigits(str8));
	}
}
