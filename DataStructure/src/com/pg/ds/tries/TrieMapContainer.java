package com.pg.ds.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieMapContainer {

	TrieMap trieMpRoot = new TrieMap();
	
	public static void main(String[] args) {

		TrieMapContainer tcc = new TrieMapContainer();
		
		String[] sar = {"AAA","aAa","ABC","abc","000","012","123"};
		for(String str : sar) {
			tcc.add(str);
		}
		/*do{
			System.out.println(tcc.tc.chr);
		}while( (tcc.tc = tcc.tc.next) != null);*/
		
		// String[] schk = {"012","aAa"};
		/*String[] schk = {"A1A","AAA","aAa","012","ABC","abc","AAAA","000"};
		for(String str : schk) {
			System.out.println(str + " : "+ tcc.isExists(str));
		}*/

		//String[] hasc = {"0","01","012","1","12","AAa"};
		//String[] hasc = {"01"};
		String[] hasc = {"A","A1","a","aA","AB","ABc","ab","011","0122","12","123","1230"};
		for(String str : hasc) {
			if(tcc.hasCharSeq(str)) {
				System.out.println(str + " : true");
			}else {
				System.err.println(str + " : false");
			}
		}

	}
	
	public void add(String w){
		add(0, w, trieMpRoot);
	}
	
	public void add(int i, String w, TrieMap curTmp) {
		if(w == null || i >= w.length()) return;
		
		char ch = w.charAt(i);
		TrieMap nTmp = curTmp.next.get(ch);
		if (nTmp == null) {
			nTmp = new TrieMap();
			curTmp.next.put(ch, nTmp);
		}
		
		if(i+1 == w.length()) {
			curTmp.endOfWord = true; }
		
		add(i+1, w, nTmp);
	}
	
	public boolean isExists(String w) {
		return isExists(0,w, trieMpRoot);
	}

	private boolean isExists(int i, String w, TrieMap curTrie) {
		if(w == null || i >= w.length()) return false;
		
		char ch = w.charAt(i);
		TrieMap nTmp = curTrie.next.get(ch);
		
		if(null == nTmp) {
			return false;
		}
		
		if(i+1 == w.length()) {
			return curTrie.endOfWord;
		}
		
		return isExists(i+1, w, nTmp);
	}
	
	public boolean hasCharSeq(String w){
		if(null != this.trieMpRoot) { 
			return isSeqExists(0, w, this.trieMpRoot);
		}
		return false;
	}
	
	private boolean isSeqExists(int i, String w, TrieMap triMp) {
		if(w == null || i >= w.length()) return false;
		
		char c = w.charAt(i);
		TrieMap nTriMp = triMp.next.get(c);
		
		if(null == nTriMp) {
			return false;
		}
		
		if(i+1 == w.length()) {
			return true;
		}
		return isSeqExists(i+1, w, nTriMp);
	}	
	
	private class TrieMap{
		Map<Character, TrieMap> next;
		boolean endOfWord;

		public TrieMap() {
			next = new HashMap<>();
			endOfWord = false;
		}
	}
}

