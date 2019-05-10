package com.pg.alg.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SplitString {

	public static void main(String... str) {

		String doc = "Bob hit a    ball, the     hit BALL flew far after   it was hit.   I don't have one.";

		List<String> wordLst = splitDoc(doc);
		

		Set<String> banSet = createBanSet(new String[] {"hit"});
		String mostFreqWord = createDictMostFreq(wordLst, banSet);
		
		System.out.println(mostFreqWord);
		


	}
	
	private static Set<String> createBanSet(String[] strings) {
		Set<String> set = Arrays.stream(strings).collect(Collectors.toSet());
		System.out.println(set);
		return set;
	}

	private static String createDictMostFreq(List<String> wordLst, Set<String> banSet) {
		Map<String, Integer> dictMp = new HashMap<String, Integer>();
		
		Map<String, Integer> counted = wordLst.stream()
	            .collect(Collectors.toMap(Function.identity(), e -> 1, Math::addExact));
		

		
		System.out.println(counted);
		
		return null;
	}

	private static List<String> splitDoc(String doc){
		List<String> wordLst = null;
		wordLst = splitToLower(doc);
		wordLst = splitToLowerRemovePunct(doc);
		return wordLst;
	}

	private static List<String> splitToLower(String doc) {
		List<String> wordLst;
		String[] words = doc.split("[,. ]+");
		
		wordLst = new ArrayList<>(Arrays.asList(words));
		wordLst.replaceAll(String::toLowerCase);
		
		System.err.println("split count " + wordLst.size());
		wordLst.forEach(ech -> System.out.println(ech));

		return wordLst;
	}

	private static List<String> splitToLowerRemovePunct(String doc) {
		List<String> wordLst = new ArrayList<String>();
		StringBuffer strb = new StringBuffer();
		for (int i = 0; i < doc.length(); i++) {
			char chr = doc.charAt(i);
			if (chr != ' ' && chr != ',' && chr != '.') {
				strb.append(String.valueOf(toLower(chr)));
			} else {
				if (strb.length() > 0) {
					wordLst.add(strb.toString());
					strb.setLength(0);
				}
			}
		}
		System.err.println("Iterate-split count " + wordLst.size());
		wordLst.forEach(ech -> System.err.println(ech));
		return wordLst;
	}

	private static char toLower(char chr){
        if(chr-'a' >=0 && chr-'a' <26){
            return chr;
        }else if(chr-'A' >=0 && chr-'A' < 26){
            return (char) (chr-'A'+'a');
        }else{
            return '\u0000';
        }

    }

}
