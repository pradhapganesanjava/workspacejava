package solstools.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shrink_Squeeze_ReverseWords {

	public static void main(String[] args) {
		Shrink_Squeeze_ReverseWords_Solution sol = new Shrink_Squeeze_ReverseWords_Solution();

	}

}
class Shrink_Squeeze_ReverseWords_Solution {
    public String reverseWords(String s) {
        return twopointer(s);
        //return linear(s);
    }
    private String twopointer(String s){
        char[] carr = s.toCharArray();
        
        reverse(carr, 0, carr.length-1);
        reverseWords(carr);
        carr = trimWhitespaces(carr);
        return new String(carr);
    }
    private char[] trimWhitespaces(char[] carr){
        int l=0, r=0, n = carr.length;
        while(r<n){
        		//R to First Letter
            while(r<n && Character.isWhitespace(carr[r])){
                r++; }
            //L Overwrite letters with R
            while(r<n && !Character.isWhitespace(carr[r])){
                carr[l++]=carr[r++]; }
            //R move to Letter; helps trim End spaces
            while(r<n && Character.isWhitespace(carr[r])){
                r++; }
            //Skip Space for End of Word
            if(r<n){
                carr[l++]=' '; }
        }
        return Arrays.copyOf(carr, l);
    }
    private void reverseWords(char[] carr){
        int l=0, r=0;
        int n = carr.length;
        while(l < n){
        		//L to start of word
            while(l<n && Character.isWhitespace(carr[l])){
               l++; }
            //R from L to end of word
            r=l;
            //R end of word
            while(r+1<n && !Character.isWhitespace(carr[r+1])){
               r++;  }
            reverse(carr, l, r);
            //L move to next word
            l=r+1; 
        }
    }
    
    private void reverse(char[] carr, int l, int r){
        //System.out.format("l: %d, r: %d \n",l,r);
        while(l<r){
            char c = carr[l];
            carr[l] = carr[r];
            carr[r] = c;
            l++;
            r--;
        }
    }
    
    /*
        > trim front, back
        > add each words (non spaced ) in List
        > construct new string reversed List
    */
    
    private String linear(String s){
        StringBuilder strb = new StringBuilder();
        List<String> slst = new ArrayList<>();
        for(int r=0; r<s.length(); r++){
            //while(s.charAt(r) Character.isBlankWhiteSpace())
            if(Character.isWhitespace(s.charAt(r))){
                if(strb.length() > 0){
                    slst.add(strb.toString());
                    strb.setLength(0);
                }
                continue;
            }else{
                strb.append(s.charAt(r));
            }
        }
        if(strb.length()>0){
           slst.add(strb.toString());
           strb.setLength(0); 
        }
        //slst.forEach(ech -> System.out.print(ech+", "));
        for(int i=slst.size()-1; i >= 0; --i){
            strb.append(slst.get(i));
            if(i-1 >= 0){
                strb.append(" ");
            }
        }
        
        return strb.toString();
    }
}