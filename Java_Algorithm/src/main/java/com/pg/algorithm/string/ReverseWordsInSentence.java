package com.pg.algorithm.string;

import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseWordsInSentence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String sentence = "Hi I love coding";
		
		usingStack(sentence);

	}

	private static void usingStack(String sentence) {
		StringTokenizer strToken = new StringTokenizer(sentence, " ");

		Stack<String> strStack = new Stack<String>();
		int count = 0;
		while (strToken.hasMoreElements()) {
			strStack.push((String) strToken.nextElement()+" ");
			count++;
		}

		StringBuilder strBuilder = new StringBuilder();
		// Iterator strStackIt = strStack.iterator();

		for (int i = 0; i < count; i++) {
			strBuilder.append(strStack.pop());
		}
		System.out.println(" Original sentence " + sentence);
		System.out.println(" reversed sentence >" + strBuilder.toString()+"<");
	}

}
