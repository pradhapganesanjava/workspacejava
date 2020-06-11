package com.pg.alg.string.traverse;

import java.util.ArrayList;
import java.util.List;

public class ZigzagStrTraverse {

	public static void main(String[] args) {
		ZigzagStrTraverse_Solution sol = new ZigzagStrTraverse_Solution();
		String s = "PAYPALISHIRING";
		int n = 3;
		sol.convert(s, n);
	}

}

class ZigzagStrTraverse_Solution {
	
    public String convert(String s, int numRows) {
        
        return recur(s, numRows);
    }
    
    private String recur(String s, int numRows) {
        List<List<Character>> lolst = new ArrayList<>(numRows);
        for(int i=0; i<numRows; i++){
            List<Character> chrLst = new ArrayList<>();
            lolst.add(chrLst);
        }
        
        recur(s, lolst, numRows, 0, 0, true);
        
        StringBuilder strb = new StringBuilder();
        for(List<Character> chrLst : lolst){
            for(Character chr : chrLst){
                strb.append(chr);
            }
        }
        return strb.toString();
    }
    
     private void recur(String s, List<List<Character>> lolst, int n, int ci, int ilst, boolean isDwn) {
         
         if( ci >= s.length() || ilst >= n || ilst < 0) return;
         List<Character> chrLst = lolst.get(ilst);
         chrLst.add(s.charAt(ci));
         
         if(ilst == n) { isDwn = false;}
         if(ilst == 0) { isDwn = true; }
             
         if(isDwn){
            recur(s, lolst, n, ci+1, ilst+1, isDwn);
         }else{
            recur(s, lolst, n, ci+1, ilst-1, isDwn); 
         }
         
     }
}