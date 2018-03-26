package com.pg.java.regex;

import java.util.Arrays;


/*
 * 
 *	Ways to combine	
	
	Repetition:
		? = 0 or 1
 		* = 0 or more
		+ = 1 or more
	
	Concatenation:
		() - group filter applies

	Alternation:
		| - OR
		[ ] - set of ORs
		[ - ] - '-' range of ORs
 * 
 */
import java.util.List;

/***
^(?:(?!test).)*$
	^               the beginning of the string
	(?:             group, but do not capture (0 or more times)
	 (?!            look ahead to see if there is not:
	  test          'test'
	 )              end of look-ahead
	 .              any character except \n
	)*              end of grouping
	$               before an optional \n, and the end of the string

 */
public class RegExBasics extends AbstractRegEx {

	public static void main(String[] args) {
		RegExBasics regExObj = new RegExBasics();
		// regExObj.matchText();
		
		// alternationTest();
		notExceptTest();
	}

	/* Alternation:
			| - OR
			[ ] - set of ORs
			[ - ] - '-' range of ORs
	 */
	private static void alternationTest(){
		
		String orTestTxt = "Teacher: (Looking at class-students) Can you repeat A,B,C,D,E,F,G...?";
		//pipe separates individual OR conditions
		alt_OR(orTestTxt,":|-");
		//groups OR conditions; elegant and avoid many pipes | 
		alt_setOf_OR(orTestTxt,"[()-]");
		//range of OR conditions; elegant and avoid many individual chars
		alt_rangeOf_OR(orTestTxt,"[A-G]");
	}
	
	private static void notExceptTest(){
		
		String str1 = "/api/signidd";
		System.out.println( str1.matches("^/api/(?!signin|signout).*$"));
		
	}
	
	
	/* Alternation: | - OR   */
	private static void alt_OR(String text, String pattern){
		printApplyRegEx(text,pattern);
	}

	/*  Alternation: [ ] - set of ORs */
	private static void alt_setOf_OR(String text, String pattern){
		printApplyRegEx(text,pattern);
	}

	/* Alternation: [ - ] - '-' range of ORs */
	private static void alt_rangeOf_OR(String text, String pattern){
		printApplyRegEx(text,pattern);
	}
	
	// split matching text
	private void matchText() {

		String text = "iaminthebushcanyoufindmewhereiam";

		List<String> strListResult = applyRegEx(text, "am");

		System.out.println(" list output " + Arrays.toString(strListResult.toArray()));
		
		/*
		 * OUTPUT:
		 *  list output [am, am]
		 * 
		 */
	}
	
	//ALTERNATION
	private void matchMany_OR(){

		String text = "iaminthebushcanyoufindmewhereiam";

		List<String> strListResult = applyRegEx(text, "am|in");

		System.out.println(" list output " + Arrays.toString(strListResult.toArray()));
		
		/*
		 * OUTPUT:
		 *  list output [am, in, in, am]
		 * 
		 */
	}
}
