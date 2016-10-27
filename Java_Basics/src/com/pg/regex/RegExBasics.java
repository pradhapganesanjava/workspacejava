package com.pg.regex;

import java.util.Arrays;
import java.util.List;

public class RegExBasics extends AbstractRegEx {

	public static void main(String[] args) {
		RegExBasics regExObj = new RegExBasics();
		regExObj.matchText();
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
