package com.pg.alg.wordprocess;

import java.util.Arrays;
import java.util.List;

public class RecognizeWords {

	public static void main(String[] args) {
		
	 String str = 	parseDocRecognizeWords("thisistimhowtomisdoing", new String[] {"this","is","how","is","doing"});
	 System.out.println(str);
	}

	private static String parseDocRecognizeWords(String doc, String[] dict) {
		
		List<String> dictLst = Arrays.asList(dict);
		
		char chr = '\u0000';
		StringBuilder strb = new StringBuilder();
		StringBuilder finalStrb = new StringBuilder();
		StringBuilder unRecogStrb = new StringBuilder();
		
		for(int idx = 0; idx<doc.length(); idx++) {
			chr = doc.charAt(idx);
			strb.append(chr);
			if(dictLst.stream().filter(wrd -> wrd.startsWith(strb.toString())).findAny().isPresent()) {
				if(dictLst.contains(strb.toString())) {
					if(unRecogStrb.length() > 0) {
						finalStrb.append(unRecogStrb);
						unRecogStrb.setLength(0);
					}
					if(finalStrb.length()>0) {
						if(finalStrb.charAt(finalStrb.length()-1) != ' ') {
							finalStrb.append(" ");
						}
					}
					finalStrb.append(strb.toString());
					finalStrb.append(" ");
					strb.setLength(0);
				}
				
			}else{
				if(strb.length() > 0) {
					unRecogStrb.append(strb.toString());
				}
			}
		}
		if(unRecogStrb.length() > 0) {
			finalStrb.append(unRecogStrb);}
		return finalStrb.toString();
	}
}
