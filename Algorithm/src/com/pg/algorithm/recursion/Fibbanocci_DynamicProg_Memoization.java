package com.pg.algorithm.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fibbanocci_DynamicProg_Memoization {
	static int memoi_cnt = 0;
	static int recur_cnt = 0;
	public static void main(String...str) {
		//fibbo_Memoi();
		fibboRecur(20);
		System.out.println();
		System.out.println("fibborecur cnt "+recur_cnt);
		
	}

	private static void fibbo_Memoi() {
		Map<Integer, Integer> mp = new HashMap<>();
		List<Integer> resLst = new ArrayList<>();
		fibboRecur(100, resLst, mp);
		System.out.println(mp);
		System.out.println(resLst.size());
		resLst.forEach(ech -> System.out.print(ech+", "));
		System.out.println();
		System.out.println("total # of execution " + memoi_cnt);
	}

	private static int fibboRecur(int n, List<Integer> resLst, Map<Integer, Integer> mp) {
		memoi_cnt++;
		if(mp.keySet().contains(n)) return mp.get(n);
		
		if(n > 0 && n <= 2) {
			mp.put(n, 1);
			resLst.add(1);
			return 1;
		}

		int resInt = fibboRecur(n-1, resLst, mp) + fibboRecur(n-2, resLst, mp);
		resLst.add(resInt);
		mp.put(n, resInt);
		return resInt;
		
	}
	
	private static int fibboRecur(int n) {
		recur_cnt++;
		if(n>0 && n<=2) return 1;
		int newFib = fibboRecur(n-1)+fibboRecur(n-2);
		System.out.print(newFib + ", ");
		return newFib;
	}
	
}
