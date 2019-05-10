package com.pg.algorithm.array;

import java.util.Stack;

public class EvalExpr {

	public static void main(String[] args) {
		String str = "2-6-7*8/2+5";
		
		Stack<String> stk = new Stack<>();
		
		for(int i=0; i<str.length();i++) {
			
			if(!"+-*/".contains(String.valueOf(str.charAt(i)))){
				stk.push(String.valueOf(str.charAt(i)));
			}else if("+-".contains(String.valueOf(str.charAt(i)))){
				int newi = i +1;
				stk.push(String.valueOf(str.charAt(newi))); //operant
				stk.push(String.valueOf(str.charAt(i))); // operator
				i = newi;
			}else if("/*".contains(String.valueOf(str.charAt(i)))){
				int newi = i +1;
				int rn = Integer.valueOf(str.charAt(newi));
				String lastOpr = stk.pop();
				String lastN = stk.pop();
				int ln = Integer.valueOf(lastN);
				int res = 0;
				if("/".equals(String.valueOf(str.charAt(i)))) {
					res = ln/rn;
				}else if("*".equals(String.valueOf(str.charAt(i)))) {
					res = ln*rn;
				}
				stk.push(String.valueOf(res));
				stk.push(lastOpr);
				i = newi;
			}
			
		}
		
		System.out.println(stk);
	}

}
