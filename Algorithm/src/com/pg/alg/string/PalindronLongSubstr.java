package com.pg.alg.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindronLongSubstr {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.longestPalindrome("abcdbbfcba"));
	}

}

class Solution {
    public String longestPalindrome(String s) {
        
        if(null == s || "".equals(s) || s.length()<2) return s;
        
        Map<Integer, List<Integer>> aprep = new HashMap<>();
        
        for(int i=0; i<s.length();i++){
            int ic = s.charAt(i)-'a';
            
            if(!aprep.keySet().contains(ic)){
                List<Integer> dxLst = new ArrayList<Integer>();
                dxLst.add(i);
                aprep.put(ic, dxLst);
            }else{
                List<Integer> dxLst = aprep.get(ic);
                dxLst.add(i);
            }
        }
        System.out.println(aprep);
        String longPalinStr = "";
        int longPalinInt = 0;
        for(int i=0; i<s.length(); i++){
            List<Integer> dxLst = aprep.get(s.charAt(i)-'a');
            if(null == dxLst || dxLst.size() <=1) continue;
            
            int istart = dxLst.get(0);
            dxLst.remove(0);
            
            for(int dx=0; dx<dxLst.size(); dx++){
                int iend = dxLst.get(dx);
                
                if(checkPanlind(s, istart, iend)){
                    int nsz = iend-istart+1;
                    if(nsz > longPalinInt){
                        longPalinInt = nsz;
                        longPalinStr = s.substring(istart, iend+1);
                    }
                }
            }
        }
        if(longPalinInt == 0) return String.valueOf(s.charAt(0));
        return longPalinStr;
    }
    
    private boolean checkPanlind(String str, int st, int ed){
        for(int i=st, j=ed; i<=j; i++, j--){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}