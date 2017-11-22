package com.pg.algorithm.array.string;

public class ReverseString {

	public static void main(String[] args) {

		System.out.println("null : reverseString "+reverseString(null));
		System.out.println("'' : reverseString "+reverseString(""));
		System.out.println("'  ' : reverseString "+reverseString("   "));
		System.out.println("p : reverseString "+reverseString("p"));
		System.out.println("pr : reverseString "+reverseString("pr"));
		System.out.println("pra : reverseString "+reverseString("pra"));
		System.out.println("pr a  : reverseString "+reverseString("pr a"));
		System.out.println("pra dhap  : reverseString "+reverseString("pra dhap"));
		System.out.println("p*%^ _-@!  : reverseString "+reverseString("p*%^ _-@!"));
	}

    public static String reverseString(String s) {
        if(null == s || "".equals(s.trim())){
            return s;
        }
        
        char[] sChar = s.toCharArray();
        int i=0;
        int len=s.length();
        int j = len - 1;
        
        while(i<j){
            char c = sChar[i];
            sChar[i] = sChar[j];
            sChar[j] = c;
            i++;
            j--;
        }
        return new String(sChar);
    }
}
