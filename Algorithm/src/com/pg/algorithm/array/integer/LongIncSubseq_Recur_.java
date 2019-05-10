package com.pg.algorithm.array.integer;

import java.util.ArrayList;
import java.util.List;

public class LongIncSubseq_Recur_ {
	public static void LIS(int arr[]) {

		List<Integer> lst = new ArrayList<>();
		recur(arr, 0, lst);
		if (null != resLst) {
			resLst.forEach(ech -> System.out.println(ech));
		}
	}

	static int mx = 0;
	static List<Integer> resLst = null;

	private static List<Integer> recur(int[] arr, int si, List<Integer> lst) {
		// if(i>arr.length) return;
		for (int i = si; i < arr.length - 1; i++) {
			if (arr[i + 1] < arr[i]) {
				continue;
			}

			lst.add(arr[i]);
			lst = recur(arr, i + 1, lst);
			if (mx < lst.size()) {
				mx = lst.size();
				resLst = lst;
			}
			if (lst.size() > 0) {
				lst.remove(lst.size() - 1);
			}
		}

		return lst;
	}
	
	static int __lis(int arr[], int si) {
		int m = 1, temp;
		for (int i = si; i < arr.length-1; i++) {
			if (arr[i] < arr[i+1]) {
				temp = 1 + __lis(arr, i+1);
				if (temp > m)
					m = temp; // m = max(m, 1 + _lis(arr, i));
			}
		}
		return m;
	}
	
	static int __LIS(int arr[]) {
		int temp, m = 0;

		for (int i = 0; i < arr.length; i++) {
			temp = __lis(arr, i);
			if (temp > m)
				m = temp;
		}
		return m;
	}	
	
	static int __lis0(int arr[], int ival, int si) {
		int m = 1, temp;
		for (int i = si; i < arr.length-1; i++) {
			if (ival < arr[i+1]) {
				temp = 1 + __lis0(arr, arr[i+1], i+1);
				if (temp > m)
					m = temp; // m = max(m, 1 + _lis(arr, i));
			}
		}
		return m;
	}
	
	static int __LIS0(int arr[]) {
		int temp, m = 0;

		for (int i = 0; i < arr.length; i++) {
			temp = __lis0(arr, arr[i], i);
			if (temp > m)
				m = temp;
		}
		return m;
	}	
	
	static List<Integer> _lis(int arr[], int lval, int si) {
		List<Integer> mLst = new ArrayList<>();
		List<Integer> tempLst  = new ArrayList<>();
		
		for (int i = si; i < arr.length; i++) {
			if (lval < arr[i]) {
				tempLst.add(arr[i]);
				List<Integer> itempLst = _lis(arr, arr[i], i+1);
				if(itempLst != null && itempLst.size()>0) {
					tempLst.addAll(itempLst);
				}
				
				if(null != tempLst && tempLst.size()>mLst.size()) {
					mLst = tempLst;
				}
			}
		}
		return mLst;
	}
	static int _LIS(int arr[]) {
		List<Integer> rLst = null;
		int m =0;
		for (int i = 0; i < arr.length; i++) {
			List<Integer> iLst = _lis(arr, arr[i], i+1);
			if (null != iLst && iLst.size() > m)
				m = iLst.size();
			    rLst =iLst;
		}
		if(rLst != null) {
			rLst.forEach(ech -> System.out.println(ech));
		}  
		return m;
	}

	public static void main(String args[]) {
		int X[] = { 3, 1, 5, 0, 6, 4, 9 };
		X = new int[] { 3, -1, 4, 0, 1 };
		// LIS(X);
		//System.out.println( _LIS(X) );
		System.out.println( _LIS(X) );
	}
}
