package com.pg.algorithm.array.string;

import java.util.Stack;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
	    public int longestValidParentheses(String s) {
	        char[] chars = s.toCharArray();
	        Stack<Integer> stack = new Stack<Integer>();
	        Stack<Integer> endPStack = new Stack<Integer>();
	        for(int i=0; i< chars.length; i++){
	            if(chars[i]=='('){
	                stack.push(i);
	            }else{
	                if(stack.size()>0){
	                    stack.pop();
	                }else{
	                    endPStack.push(i);
	                }  
	            } 
	        }
	        int maxLen = 0;
	        if(stack.size()>0){
	            while(stack.size()>0){
	                int index = stack.pop();
	                String subStr = s.substring(index, s.length()-1);
	                int len = null!=subStr?subStr.length():0;
	                maxLen = Math.max(len,maxLen);
	            }
	            while(endPStack.size()>0){
	                int index = endPStack.pop();
	                String subS = s.substring(index, s.length()-1);
	                int len = null!=subS?subS.length():0;
	                maxLen = Math.max(len,maxLen);
	            }
	        }
	        return maxLen;
	    }
	}
}

class ActualSolution {
public int longestValidParentheses(String str) {
		char[] s = str.toCharArray();
        int n = s.length, longest = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') st.push(i);
            else {
                if (!st.isEmpty()) {
                    if (s[st.peek()] == '(') st.pop();
                    else st.push(i);
                }
                else st.push(i);
            }
        }
        if (st.empty()) longest = n;
        else {
            int a = str.length(), b = 0;
            Stack<Integer> stm = new Stack<>();//odd index
            while (!st.empty()) {
                b = st.peek(); 
                st.pop();
                longest = Math.max(longest, a-b-1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }
}
