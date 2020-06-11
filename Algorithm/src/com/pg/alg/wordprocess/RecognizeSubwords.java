package com.pg.alg.wordprocess;

import java.util.Arrays;

public class RecognizeSubwords {

	static int compareByLen(String s1, String s2) {
		return s1.length() > s2.length() ? 1 : -1;
	}
	
	public static void main(String[] args) {
		String[] strArr = new String[] {
				"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"
		};
		
		int len = strArr.length;
		
		Trie trie = new Trie();
		
		for(int i = 0; i < len; i++) {
			trie.addWord(strArr[i]);
		}
		
		Arrays.sort(strArr, RecognizeSubwords::compareByLen);
		boolean found = false;
		
		for(int i = len -1; i >=0; i--) {
			String cw = strArr[i];
			int idx = trie.prefixWord(cw);
			while(idx > -1) {
				cw = cw.substring(idx);
				if(cw.length()==0) {
					System.out.println("Long wrd "+strArr[i]);
					found = true;
					break;
				}
				idx = trie.prefixWord(cw);
			}
			if(found) break;
		}
		
		
	}

}

class Trie{
	TrieNd trie = null;
	
	public Trie() {
		trie = new TrieNd();
	}
	
	public void addWord(String wrd) {
		TrieNd curTrie = this.trie;
		for(char chr : wrd.toCharArray()) {
			int ic = chr - 'a';
			if(curTrie.next[ic] == null) {
				curTrie.next[ic] = new TrieNd();
				
			}
			curTrie = curTrie.next[ic];
		}
		curTrie.isEow = true;
	}
	
	public int prefixWord(String wrd) {
		TrieNd curTrie = trie;
		int i = -1;
		for(char chr : wrd.toCharArray()) {
			i++;
			int ic = chr - 'a';
			if(curTrie.next[ic] != null) {
				if(curTrie.isEow) {
					return i;
				}
				curTrie = curTrie.next[ic];
			}else {
				break;
			}
		}
		if(curTrie.isEow) {
			return i;
		}else {
			return i;
		}
	}
}
class TrieNd{
	TrieNd[] next = new TrieNd[26];
	boolean isEow = false;
//	@Override
//	public String toString() {
//		StringBuilder strb = new StringBuilder();
//		for(int i = 0; i<26; i++) {
//			if(this.next[i]!= null) {
//				strb.append(String.format("%d", i));
//			}
//		}
//		return strb.toString();
//	}
}

