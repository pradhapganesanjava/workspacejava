package com.pg.alg.string;

import java.util.Arrays;
import java.util.Stack;

public class BalancedBraces_Stack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "a{b{c}d}{}{}";
		String strArr[] = str.split("");
		System.out.println("StrArr: " + Arrays.toString(strArr));
		if (checkBalancedBraces_StackImpl(strArr)) {
			System.out.println("Str: " + str + " contains Balanced Braces");
		} else {
			System.out.println("Str: " + str + " NOT contain Balanced Braces");
		}
	}

	private static boolean checkBalancedBraces_StackImpl(String[] strArr) {
		int index = 0;
		int count = 0;
		Stack<String> stack = new Stack<String>();
		while (index < strArr.length) {
			String str = strArr[index].intern();
			if (null != str && "{" == str) {
				stack.push("{");
				count++;
			} else if (null != str && "}" == str) {
				if(count==0){
					return false;
				}
				count--;
				stack.pop();
			}
			index++;
		}
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}
}
