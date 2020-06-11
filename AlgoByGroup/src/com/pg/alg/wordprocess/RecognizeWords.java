package com.pg.alg.wordprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public class RecognizeWords {

	public static void main(String[] args) {
	 String contSeqChars = "";
	  contSeqChars = "jesslookedjustliketimherbrother";
	  //contSeqChars = "lookedjustliketimherbrother";
	 print_Ord_Comb_Str_N2(contSeqChars, WordOfDictionary.getListOfWords());
//	 String str = 	parseDocRecognizeWords("thisistimhowtomisdoing", new String[] {"this","is","how","is","doing"});
//	 System.out.println(str);
	}

	private static void print_Ord_Comb_Str_N2(String contSeqChars, String[] dicWrds) {
		
		TrieCharArr trie = new TrieCharArr();
		
		for(String str: dicWrds) {
			trie.addWord(str);
		}
		
		int len = contSeqChars.length();
		List<String> possWrd = new ArrayList<>();
		AtomicInteger atomInt = new AtomicInteger();
		
		Map<Integer, String> validWrdMp = new HashMap<>();
		for(int i=0; i<len; i++) {
			StringBuilder strb = new StringBuilder();
			int mxLen = -1;
			for(int j=i; j<len; j++) {
				atomInt.incrementAndGet();
				strb.append(contSeqChars.charAt(j));
				String wrd = strb.toString();
				possWrd.add(wrd);
				if(trie.isWord(wrd)) {
					validWrdMp.put(i, wrd);
					mxLen = j;
				}
			}
			if(mxLen !=-1) {
				i=mxLen;
			}
		}
		StringBuilder spacedStrb = new StringBuilder();
		List<Integer> idxLst = new ArrayList<Integer>(validWrdMp.keySet());
		Collections.sort(idxLst);
		
		int lIdx = 0;
		//for(Entry<Integer, String> entry : validWrdMp.entrySet()) {
		for(Integer key : idxLst) {
			int curIdx = key;
			if(lIdx < curIdx) {
				spacedStrb.append(contSeqChars.substring(lIdx,curIdx));
				spacedStrb.append(" ");
			}
			spacedStrb.append(contSeqChars.substring(curIdx, curIdx+validWrdMp.get(curIdx).length()));
			spacedStrb.append(" ");
			lIdx = curIdx + validWrdMp.get(curIdx).length();
		}
		System.out.format("ReSpaced %s \n", spacedStrb.toString());
		
		System.out.format("Len: %d, timeComplex: %d, size of word comb %d \n", len, atomInt.get(), possWrd.size());
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
