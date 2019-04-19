package com.pg.alg.string;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/*
 You are given a string S and a set of n substrings. 
 You are supposed to remove every instance of those n substrings from S 
 so that S is of the minimum length and output this minimum length.
 Eg:
 S� ccdaabcdbb
 n=2 � substrings�� ab, cd
 Output: 2
 Explanation:
 ccdaabcdbb �> ccdacdbb �> cabb �> cb (length=2)
 * 
 */
public class RemoveSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "ccdaabcdbb";
		String[] sArr = s.split("");
		Stack<String> stack = new Stack<String>();
		int count = 0;
		// count = tryOne(sArr, stack, count);
		int subStrSize = 3;
		String removeString1 = "abc";
		String removeString2 = "cd";

		count = removeSubstringRoutine(sArr, stack, count, subStrSize, removeString1, removeString1);

		System.out.println(" stack size " + count);
		for(int i=0;i<count;i++){
			System.out.print(""+stack.pop());
		}

	}

	private static int removeSubstringRoutine(String[] sArr, Stack<String> stack, int count, int subStrSize,
			String... removeString) {
		for (int i = sArr.length - 1; i > 0; i--) {

			String curStr = sArr[i];
			if (count < subStrSize) {
				stack.push(curStr);
				count++;
				continue;
			}else{
				stack.push(curStr);
				count++;
			}

			String concatStr = "";
			String[] popStr = new String[subStrSize];

			for (int j = 0; j < subStrSize && count>0; j++) {
				popStr[j] = stack.pop();
				concatStr +=popStr[j];
				count--;
			}
			//concatStr = String.va(popStr);
			if (!(concatStr.equals(removeString[0]) || concatStr.equals(removeString[1]))) {
				for (int j = subStrSize-1; j >= 0; j--) {
					// concatStr +=stack.pop();
					stack.push(popStr[j]);
					count++;
				}
			}

		}
		return count;
	}

	private static int tryOne(String[] sArr, Stack<String> stack, int count) {
		for (int i = sArr.length - 1; i > 0; i--) {

			String pushStr = sArr[i];
			String concatStr = sArr[i - 1];
			if (count > 1) {
				stack.push(pushStr);
				count++;
			}

			String subStr = concatStr + stack.peek();
			if ((subStr.equals("ab") || subStr.equals("cd")) && count > 0) {
				stack.pop();
				count--;
				i--;
			}
		}
		return count;
	}

}
