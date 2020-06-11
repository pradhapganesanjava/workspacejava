package com.pg.alg.string.transform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Wordladder_Cnt {

	public static void main(String[] args) {
		Wordladder_Cnt_Solution sol = new Wordladder_Cnt_Solution();
		int cnt = sol.ladderLength(
				//"hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")
				"hot", "dog", Arrays.asList("hot","dog","dot")
				);
		System.out.println(cnt);
	}

}

class Wordladder_Cnt_Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
    		// return intuitiveBFS_Int(beginWord, endWord, wordList);
        
        return wordLadderRecurImpl (beginWord, endWord, wordList);
        
    }
    private int intuitiveBFS_Int(String beginWord, String endWord, List<String> wordList){
        if(null == beginWord || null == endWord) return 0;
        
        int slen = beginWord.length();
        
        Set<String> dicSt = new HashSet<>();
        for(String word : wordList){
            if(word.length() == slen){
                dicSt.add(word); }
        }
        return findPath_Int(beginWord, endWord, dicSt);
        
    }
    
    private int findPath_Int(String beginWord, String endWord, Set<String> dicSt){
        Queue<String> q = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        q.add(beginWord);
        int slen = beginWord.length();
        int res = 0;
        while(!q.isEmpty()){
          int qsize = q.size();
          for(int k=qsize; k>0; k--){
            String parent = q.remove();
            if(visit.contains(parent)) continue;
            if(parent.equals(endWord)){
                return res+1;}            
            visit.add(parent);
            for(int i=0; i<slen; i++){
                 StringBuilder strb = new StringBuilder(parent);
                for(int c=0; c<26; c++){
                    strb.setCharAt(i,(char)('a'+c));
                    String nwrd = strb.toString();
                    
                    if(dicSt.contains(nwrd) && !visit.contains(nwrd)){
                        q.add(nwrd);
                    }
                }
            }
          }
          res++;
        }
        return 0;
    }  
    
    private int wordLadderRecurImpl(String beginWord,String endWord, List<String> wordList){

        Set<String> dicSt = createDictSet(wordList, beginWord.length());

        Set<String> visit = new HashSet<>();
        
        dicSt.add(beginWord);

        List<String> path = wordLadderRecur(beginWord, endWord, dicSt, visit);
        
        if(path != null) {
        		path.forEach( ech -> {
        			System.out.print(ech + " -> ");
        		});
        }
        
        return path == null ? 0 : path.size();
    }

    private LinkedList<String> wordLadderRecur(String startWord, String endWord, Set<String> dicSt, Set<String> visit){

        if(endWord.equals(startWord)) {
			LinkedList<String> wrdLst = new LinkedList<String>();
			wrdLst.add(endWord);
			return wrdLst;
		} else if (!dicSt.contains(startWord) || visit.contains(startWord)) {
			return null;
		}

        visit.add(startWord);

        List<String> explrWords = createAllPossibleWords(startWord);

        for(String wrd : explrWords){
            LinkedList<String> path = wordLadderRecur(wrd, endWord, dicSt, visit);
            if(path != null){
            		if(wrd.equals(endWord)) return path;
                path.addFirst(wrd);
                return path;
            }
        }

        return null;
    }
    private List<String> createAllPossibleWords(String startWrd){
        List<String> wrdLst = new ArrayList<>();
        for(int i=0; i<startWrd.length(); i++){
             StringBuilder strb = new StringBuilder(startWrd);
            for(int c=0; c<26; c++){
                strb.setCharAt(i,(char)('a'+c));
                wrdLst.add(strb.toString());
            }
        } 
        return wrdLst;
    }
    private Set<String> createDictSet(List<String> wordList, int slen){
        Set<String> dicSt = new HashSet<>();
            for(String word : wordList){
                if(word.length() == slen){
                    dicSt.add(word); }
            }
        return dicSt;
    }
}