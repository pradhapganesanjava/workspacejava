package com.pg.alg.subset;

import java.util.ArrayList;
import java.util.List;

public class SubsetLenKofN {

	public static void main(String[] args) {
		subset(5, 2);
	}

	private static void subset(int N, int K) {
		List<Integer> lst = new ArrayList<>();
		List<List<Integer>> lolst = new ArrayList<>();
		subset(N, K, lst, lolst);
		for(List<Integer> tlst : lolst) {
			tlst.forEach(ech -> System.out.print(ech + ", "));
			System.out.println();
		}
	}

	private static void subset(int n, int k, List<Integer> lst, List<List<Integer>> lolst) {
		
		if(lst.size()==k) {
			lolst.add(lst);
			return;
		}
		for(int i=n; i>0; i--) {
			List<Integer> nlst = new ArrayList<>(lst);
			nlst.add(i);
			subset(i-1, k, nlst, lolst);
		}
	}

}
