package com.pg.alg.wordprocess;

public class TrieCharArr {
	
	TrieCharArr.TrieNode trdRoot = new TrieNode();
	
	public void addWord(String word) {
		addWordRecur(trdRoot, word, 0);
	}
	
	public boolean isWord(String word) {
		return isWordExistRecur(trdRoot, word, 0);
	}

	
	private boolean isWordExistRecur(TrieNode curNd, String word, int idx) {
		if(idx >= word.length()) return false;
		
		int trIdx = word.charAt(idx);
		if(null == curNd.next[trIdx]) {
			return false;
		}else {
			curNd = curNd.next[trIdx];
		}
		if(idx == word.length()-1) {
			return curNd.isWord;
		}
		return isWordExistRecur(curNd, word, idx + 1);
	}

	private void addWordRecur(TrieNode curNd, String word, int idx) {
		if(idx >= word.length()) return;
		int trIdx = word.charAt(idx);
		if(null == curNd.next[trIdx]) {
			curNd.next[trIdx] = new TrieNode();
			curNd = curNd.next[trIdx];
		}else {
			curNd = curNd.next[trIdx];
		}
		if(idx == word.length()-1) {
			curNd.isWord = true;
		}
		addWordRecur(curNd, word, idx + 1);
	}


	private class TrieNode{
		TrieNode[] next = new TrieNode[126];
		boolean isWord;
		
		public boolean isWord() {
			return isWord;
		}
		public void setWord(boolean isWord) {
			this.isWord = isWord;
		}
	}
}
