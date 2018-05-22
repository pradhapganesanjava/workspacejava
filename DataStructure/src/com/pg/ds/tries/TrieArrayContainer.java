package com.pg.ds.tries;

public class TrieArrayContainer {

	TrieChars tc = new TrieChars();
	
	public static void main(String[] args) {

		TrieArrayContainer tcc = new TrieArrayContainer();
		
		String[] sar = {"AAA","aAa","012","ABC","abc"};
		//String[] sar = {"012","120","210","000","010"};
		for(String str : sar) {
			tcc.add(str);
		}
		
		TrieChars[] curTrieArr = tcc.tc.next;
		/*
		for(TrieChars t : curTrieArr) {
			while(null != t.next) {
			
				System.out.println(t.toString());
			}
			curTrieArr = curTrieArr.
		}
		*/
		
		String[] schk = {"012","aAa","A1A","AAAA","abcc","abc"};
		for(String str : schk) {
			System.out.println(str + " : "+ tcc.isExists(str));
		}

		//String[] hasc = {"0","01","012","1","12","AAa"};
		//String[] hasc = {"01"};
		/*
		String[] hasc = {"A1A"};
		for(String str : hasc) {
			System.out.println(str + " : "+ tcc.hasCharSeq(str));
		}
		*/

	}
	
	public boolean hasCharSeq(String w){
		if(null != tc) { 
			return isSeqExists(0, w, this.tc);
		}
		return false;
	}
	
	private boolean isSeqExists(int ind, String w, TrieChars tcl) {
		if(w == null || ind >= w.length()) return false;
		
		if(w == null || ind >= w.length()) return false;
		char c = w.charAt(ind);
		TrieChars nTrie = tcl.next[(int)c];
		if(nTrie == null) {
			return false;
		}
		
		if(ind+1 == w.length()) {
			return true;
		}
		
		return isSeqExists(ind+1, w, nTrie);
	}
	

	public boolean isExists(String w) {
		return isExists(0,w, tc);
	}
	
	private boolean isExists(int ind, String w, TrieChars tcl) {
		if(w == null || ind >= w.length()) return false;
		char c = w.charAt(ind);
		TrieChars nTrie = tcl.next[(int)c];
		if(nTrie == null) {
			return false;
		}
		
		if(ind+1 == w.length()) {
			return tcl.eod;
		}
		
		return isExists(ind+1, w, nTrie);
	}

	public  void add(String w){
		add(0, w, tc);
	}
	public  void add(int ind, String w, TrieChars tcl) {
		if(w == null || ind >= w.length()) return;
		char c = w.charAt(ind);
		TrieChars nTrie = tcl.next[(int)c];
		if(nTrie == null) {
			nTrie = new TrieChars();
			tcl.next[(int)c] = nTrie;
		}
		//if(tcl.next==null) tcl.next = new TrieChars();
		if(ind+1 == w.length()) {
			tcl.eod= true;
		}
		add(ind+1,w, nTrie);
	}
	
	private class TrieChars {
			private TrieChars[] next = new TrieChars[256];
			private boolean eod = false;
			public String toString() {
				return this.next.toString()+", "+this.eod;
			}
	}

}

