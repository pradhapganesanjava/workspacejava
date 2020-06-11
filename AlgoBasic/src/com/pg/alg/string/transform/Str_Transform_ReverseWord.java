package com.pg.alg.string.transform;

import java.util.Arrays;

public class Str_Transform_ReverseWord {

	public static void main(String[] args) {

		Str_Transform_ReverseWord_Solution sol = new Str_Transform_ReverseWord_Solution();
		sol.reverseWords("   A    B    ");
	}

}

class Str_Transform_ReverseWord_Solution {
    public String reverseWords(String s) {
        
        if(s == null || "" == s.trim()) return "";
        char[] carr = s.toCharArray();
        //trim
        char pv = '\u0000';
        int ci = 0;
        for(int i=0; i<carr.length; i++){
           // if(' ' == carr[i] || '\u0000'== carr[i]){
            if(Character.isSpaceChar(carr[i])){
                pv = ' ';
                continue;
            }
            if(ci!=0 && Character.isSpaceChar(pv)){
                carr[ci]=' ';
                ci++;
            }
            carr[ci]=carr[i];
            ci++;
            pv='X';
        }
        if(ci < s.length()){
            for(int i=ci; i<s.length(); i++){
                carr[i]=' ';
            }
        }
        System.out.println("Trimed: "+String.valueOf(carr));
        int len = ci;
        //reverse string
        for(int i=0; i<len/2; i++){
            char tch = carr[i];
            carr[i] = carr[len-1-i];
            carr[len-1-i] = tch;
        }
        System.out.println("Reversed: "+String.valueOf(carr));
        
        int j = 0;
        //reverse words
        while(j<len){
            int i=j; 

            while((j<len) && carr[j] != ' '){
                j++;
            }
            int m = j-1;
            for(int r=i; r<i+((j-i)/2); r++,m--){
                char tch = carr[r];
                carr[r] = carr[m];
                carr[m] = tch;
            }  
            System.out.println("Reverse words: "+String.valueOf(carr));
            j++;
        }
        return String.valueOf(Arrays.copyOf(carr,len));
        
    }}
