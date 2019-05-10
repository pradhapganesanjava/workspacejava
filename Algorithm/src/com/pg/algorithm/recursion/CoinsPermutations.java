package com.pg.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class CoinsPermutations {
	
	static int perf = 0;

	public static void main(String[] args) {
		int[] dscArr = new int[] {25,10,5,1};
		int[] ascArr = new int[] {1,5,10,25};
		int counts = coinsPermutRecur(ascArr, 0, 6, new ArrayList<Integer>());
		System.out.println("perf " + perf + "cnts "+counts);
		
	}

	private static int coinsPermutRecur(int[] arr, int tot, int n, List<Integer> coins) {
		int cnt = 0;
		if(tot == n) {
			coins.forEach( ech -> System.out.print(ech+", "));
			System.out.println();
			return 1;
		}else if(tot > n) {
			return 0;
		}
		
//		for(int i=0; i<arr.length; i++) {
		for(int i= arr.length -1; i >=0; --i) {
			int cur = arr[i];
			//if(coins.contains(cur)) continue;
			coins.add(cur);
			tot += cur;
			perf++;
			int newCnt = coinsPermutRecur(arr, tot, n, coins);
			
			/*tot = tot- cur;
			cnt += cnt;
			coins.remove(coins.size()-1);*/
			
			tot -= cur;
			cnt +=newCnt;
			coins.remove(coins.size()-1);
			
			/*
			if(newCnt == 1) {
				tot -= cur;
				cnt +=newCnt;
				coins.remove(coins.size()-1);
			}else if(newCnt == -1) {
				tot -= cur;
				coins.remove(coins.size()-1);	
				return cnt;
			}
			*/
			
		}
		
		return cnt;
	}

}
