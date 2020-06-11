package com.pg.alg.path.distinct;

import java.util.ArrayList;
import java.util.List;

public class ClaimbStairs {

	public static void main(String[] args) {
		pathToN(10);
	}

	private static void pathToN(int n) {
		List<Integer> lst = new ArrayList<>();
		List<List<Integer>> lolst = new ArrayList<>();
		ArrayList[] mem = new ArrayList[n+1];
		pathToN(0, n, lst, lolst, mem);
		for(List<Integer> tlst:lolst) {
			tlst.forEach(ech -> System.out.print(ech +" ,"));
			System.out.println();
		}
	}

	private static void pathToN(int idx, int n, List<Integer> lst, List<List<Integer>> lolst, ArrayList[] mem) {
		if(idx==n) {
			lolst.add(lst);
			return;
		}else if(idx>n) {
			return;
		}
		if(mem[n] != null) {
			lst.addAll(mem[n]); return;
		}
		for(int i=1; i<=2; i++) {
			List<Integer> nlst = new ArrayList<>(lst);
			nlst.add(n);
			pathToN(idx+i, n, nlst, lolst, mem);
		}
		mem[n]=new ArrayList(lst);
	}

}
