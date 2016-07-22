package com.pg.java.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSyllables {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//([aeiouy]+)|([aeiouy]+)[^e?]|[a-df-z]e
		System.out.println(Arrays.toString(RegExTokenUtil.getTokens("([aeiouy]+)", "teseue").toArray()));

		countSyllables("segue");
		countSyllables("the");
		countSyllables("sentences");
		countSyllables("sentence");
		countSyllables("fly");
		countSyllables("yes");
		countSyllables("cave");
		countSyllables("double");
		countSyllables("contiguous");
		countSyllables("sleepy");
		countSyllables("obvious");
		countSyllables("toga");
		
	}

	
	static int countSyllables(String word)
	{
		System.out.print(word+" ");
		// TODO: Implement this method so that you can call it from the 
	    // getNumSyllables method in BasicDocument (module 1) and 
	    // EfficientDocument (module 2).
		
		List<String> syllables = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile("[aeiouy]+");
		Matcher m = tokSplitter.matcher(word);
		
		while (m.find()) {
			syllables.add(m.group());
		}

		//Set<String> syllablesSet = new HashSet<String>(syllables);
		/*if (null != syllables){
			if(syllables.size() > 1 && (syllablesSet.contains("e") || syllablesSet.contains("E"))){
				return syllables.size()-1;
			}else{
				return syllables.size();
			}
		}*/
		int index=0;
		/*int eCount=0;
		for(String str:syllables){
			index++;
			if(str.contains("e") || str.contains("E")){
				eCount++;
			}
		}*/

		int syllables2Size=0;
		char lastChar = 0;
		if (word.length() > 1) {
			lastChar = word.charAt(word.length() - 1);
		}
		if ((lastChar == 'e' || lastChar == 'E')) {
			List<String> syllables2 = new ArrayList<String>();
			Matcher m2 = tokSplitter.matcher(word.substring(0, word.length() - 1));
			
			while (m2.find()) {
				syllables2.add(m2.group());
			}
			syllables2Size=syllables2.size();
		}		
		
		if(syllables2Size!=0&&syllables2Size!=syllables.size()){
			index=syllables2Size;
		}else
		{
			index=syllables.size();
		}
		System.out.print(""+index);
		System.out.println();
	    return index;
	}
}
