package solstools.array.toposort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SmallestLexRemoveDups {

	public static void main(String[] args) {
		SmallestLexRemoveDups_Solution sol = new SmallestLexRemoveDups_Solution();
		sol.removeDuplicateLetters("zmnabcabcnm");
	}

}

class SmallestLexRemoveDups_Solution {
    public String removeDuplicateLetters(String s) {
       return toposort(s);
    }
    
    private String toposort(String s){
        Map<Character, Set<Character>> indeg
            = new HashMap<>();
        Set<Character> st = new HashSet<>();
        for(char ch : s.toCharArray()){
            indeg.put(ch, st);
            Set<Character> nst = new HashSet<>(st);
            nst.add(ch);
            st = nst;
        }
        System.out.println(indeg);
        Queue<Character> q = new LinkedList<>();
        Integer mnSz = null;
        char mnCh = '-';
        for(Map.Entry<Character, Set<Character>> entry : indeg.entrySet()){
            if(null != entry.getValue() && entry.getValue().size()==0){
                q.add(entry.getKey());
            }else{
                if(null != entry.getValue() 
                     && (mnSz == null || mnSz > entry.getValue().size())){
                    mnCh = entry.getKey();
                    mnSz = entry.getValue().size();
                }
            }
        }
        if(q.size() == 0){
            q.add(mnCh);
        }
        StringBuilder strb = new StringBuilder();
        int[] carr = new int[26];
        while(!q.isEmpty()){
            char c = q.remove();
            if(carr[c-'a']==0){
                strb.append(c);
                carr[c-'a']++;
            }
            mnSz = null;
            mnCh = '-';
            for(Map.Entry<Character, Set<Character>> entry : indeg.entrySet()){
                if(carr[entry.getKey()-'a']!=0){
                    continue;
                }      	
                if(null != entry.getValue() && entry.getValue().contains(c)){
                    entry.getValue().remove(c);
                    if(entry.getValue().size()==0){
                        q.add(entry.getKey());
                    }
                }
                if(null != entry.getValue() 
                     && (mnSz == null || mnSz > entry.getValue().size())){
                    mnCh = entry.getKey();
                    mnSz = entry.getValue().size();
                }
            }
            if(q.size() == 0 && mnCh != '-'){
                q.add(mnCh);
            }
            mnCh='-';
        }
        return strb.toString();
    }
}