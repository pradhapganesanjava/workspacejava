package com.pg.alg.string.palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePermutation_267 {

	public static void main(String[] args) {
		
		PalindromePermutation_267_Solution sol = new PalindromePermutation_267_Solution();
		sol.generatePalindromes("aaaabbbbcccc");
		
	}

}
class PalindromePermutation_267_Solution {
    public List<String> generatePalindromes(String s) {
        return intuitiveTry(s);
    }
    
    /*
      check Palindrome doable
      shorter the string to half
      generate Permutation for duplicate string
    */
    private List<String> intuitiveTry(String s){
        if(s == null || s.trim() == "") return new ArrayList<String>(0);
        
        if(!isPalindromeDoable(s)) return new ArrayList<String>(0);
        
        char[] chArr = s.toCharArray();
        Arrays.sort(chArr);
        
        char[] chArrHalf = new char[s.length()/2];
        char midCh = '\u0000';
    
        for(int i=0, ni=0; i<chArr.length; i++){
            if(i+1<chArr.length && chArr[i]==chArr[i+1]){
                chArrHalf[ni++] = chArr[i];
                i+=1;
            }else{
                midCh = chArr[i];
            }
        }
        
        List<char[]> permLst = permutationDups(chArrHalf);
        permLst.forEach(ech -> System.out.println(Arrays.toString(ech)));
        List<String> palindromPermLst = new ArrayList<>();
        for(char[] echChArr : permLst){
            StringBuilder strb = new StringBuilder(s);
            if(s.length() %2 != 0){
                strb.setCharAt(s.length()/2, midCh);
            }
            int l=0;
            int r = s.length() -1;
            while(l<r){
                strb.setCharAt(l,echChArr[l]);
                strb.setCharAt(r,echChArr[l]);
                l++;
                r--;
            }
            palindromPermLst.add(strb.toString());
        }
        return palindromPermLst;
    }
    private List<char[]> permutationDups(char[] chArr){
        List<char[]> arrLst = new ArrayList<>();
        permutationDups(chArr, 0, arrLst);
        return arrLst;
    }
    private void permutationDups(char[] chArr, int idx, List<char[]> arrLst){
        if(idx == chArr.length){
            arrLst.add(Arrays.copyOf(chArr,chArr.length));
            return;
        }
        for(int i=idx; i<chArr.length; i++){
            if(i>idx && chArr[i] == chArr[idx]) continue;
            swap(chArr, i, idx);
            permutationDups(chArr, idx+1, arrLst);
            swap(chArr, i, idx);
        }
    }
    private void swap(char[] chArr, int i, int j){
        char ch = chArr[i];
        chArr[i] = chArr[j];
        chArr[j] = ch;
    }
    
    private boolean isPalindromeDoable(String s){
        int[] count = new int[128];
        for(char ch : s.toCharArray()){
            if(count[ch] == 0){
                count[ch]++;
            }else{
                count[ch]--;
            }
        }
        int cnt = 0;
        for(int i=0; i<count.length; i++){
            if(count[i] > 0){
                cnt++;
            }
            if(cnt > 1 || cnt == 1 && s.length() %2 == 0) return false;
        }
        return cnt ==0 || cnt == 1;
    }
    
}