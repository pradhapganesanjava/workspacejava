package leetc.tree.tries;

public class Trie {
    TrieNode root = new TrieNode();
	public TrieNode buildTrie(String[] words) {
	    for (String w : words) {
	    	TrieNode p = root;
	        for (char c : w.toCharArray()) {
	            int i = c - 'a';
	            if (p.next[i] == null) p.next[i] = new TrieNode();
	            p = p.next[i];
	       }
	       p.word = w;
	    }
	    return root;
	}
	
	public void insert(String word){
		TrieNode p = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.next[i] == null) p.next[i] = new TrieNode();
            p = p.next[i];
       }
       p.word = word;
	}

	public boolean startsWith(String str) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean search(String str) {
		// TODO Auto-generated method stub
		return false;
	}
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}