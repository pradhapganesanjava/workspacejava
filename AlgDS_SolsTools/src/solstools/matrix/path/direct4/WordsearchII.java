package solstools.matrix.path.direct4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 
    <a href="https://leetcode.com/problems/word-search-ii/">212. Word Search II</a>
	Given a 2D board and a list of words from the dictionary, find all words in the board.
	
	Each word must be constructed from letters of sequentially adjacent cell, 
	where "adjacent" cells are those horizontally or vertically neighboring. 
	The same letter cell may not be used more than once in a word.
	
	Example1:	
	Input: 
	board = [
	  ['o','a','a','n'],
	  ['e','t','a','e'],
	  ['i','h','k','r'],
	  ['i','f','l','v']
	]
	words = ["oath","pea","eat","rain"]
	Output: ["eat","oath"]

	Example1:	
	Input: 
	board = [
	  ['a','a','a','a'],
	  ['a','a','a','a'],
	  ['a','a','a','a'],
	  ['a','a','a','a']
	]
	words = ["aaa","aaaaa","aaaaaaa","aaaaaaaaaaaaaa"]
	Output: ["aaa","aaaaa","aaaaaaa","aaaaaaaaaaaaaa"]
	Note:	
	All inputs are consist of lowercase letters a-z.
	The values of words are distinct.
 * 
 */
public class WordsearchII {

	public static void main(String[] args) {
		WordsearchII_Solution sol = new WordsearchII_Solution();
		
		char[][] board = {  {'a','a','a','a'},
							{'a','a','a','a'},
							{'a','a','a','a'},
							{'a','a','a','a'} };
		String[] words = {"aaa","aaaaa","aaaaaaa","aaaaaaaaaaaaaa"};
		List<String> slst = sol.findWords(board, words);
		
		slst.forEach( ech -> System.out.print(ech+","));
		
		
	}

}

class WordsearchII_Solution {
    public List<String> findWords(char[][] board, String[] words) {
        return trieDfs(board, words);
    }
    
    private List<String> trieDfs(char[][] grid, String[] dic){
        Trie trie = new Trie();
        for(String s : dic){
            trie.addWord(s);
        }
        Set<String> wset = new HashSet<>();
        
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                StringBuilder strb = new StringBuilder();
                //strb.append(grid[r][c]);
                dfs(grid, r, c, strb, trie, wset);
            }
        }
        return new ArrayList<>(wset);
    }
    
    private void dfs(char[][] grid, int r, int c, StringBuilder strb, Trie trie, Set<String> wset){
        if(r<0||r>=grid.length||c<0||c>=grid[0].length||grid[r][c]=='$'){
            return;
        }

        TrieNode tnd = trie.isExist(strb.toString()+grid[r][c]);
        if(tnd == null){
            return;
        }
        
        if(tnd.isWord && !wset.contains(tnd.word)){
            wset.add(tnd.word);
        }
        strb.append(grid[r][c]);
        char preCh = grid[r][c];
        grid[r][c]='$';
        
        dfs(grid, r, c+1, strb, trie, wset);
        dfs(grid, r+1, c, strb, trie, wset);
        dfs(grid, r-1, c, strb, trie, wset);
        dfs(grid, r, c-1, strb, trie, wset);
        grid[r][c]=preCh;
        strb.setLength(strb.length()-1);
    }
}

class Trie{
    TrieNode rnd = new TrieNode();
    
    public void addWord(String word){
        addWordPre(word);
    }
    private void addWordPre(String word){
        TrieNode cnd = this.rnd;
        for(char ch : word.toCharArray()){
            if(cnd.next[ch-'a'] == null){
                cnd.next[ch-'a'] = new TrieNode();
            }
            cnd = cnd.next[ch-'a'];
        }
        cnd.isWord = true;
        cnd.word = word;
    }
    public TrieNode isExist(String word){
        TrieNode cnd = rnd;
        for(char ch : word.toCharArray()){
            if(cnd.next[ch-'a'] == null){
                return null;
            }
            cnd = cnd.next[ch-'a'];
        }
        return cnd;
    }
    public boolean hasNext(TrieNode cnd, char ch){
        if(cnd == null) return false;
        TrieNode nxtNd = cnd.next[ch-'a'];
        return nxtNd != null;
    }
    public TrieNode next(TrieNode cnd, char ch){
        if(cnd == null) return null;
        TrieNode nxtNd = cnd.next[ch-'a'];
        return nxtNd;
    }
    public TrieNode getPreTrie(){
        return this.rnd;
    }
}
class TrieNode{
    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
    String word = "";
}