package com.pg.algorithm.array.integer;

import java.util.ArrayList;
import java.util.List;

public class SumMatchSubst {

	private static int[] arr = { 8, 2, 3, 1, 5, 2, 6,1,7 };
	private static int len = arr.length;
	private static int sum = 7;

	public static void main(String[] args) {
		
		List<List<Integer>> finalRes = new ArrayList<>(len);
		
		for (int i = 0; i < len; i++) {

			List<Integer> tRes = new ArrayList<>();
			int tsum = 0;

			if (arr[i] > sum) {
				continue;
			} else if (arr[i] == sum) {
				finalRes.add(tRes);
				continue;
			}
			tRes.add(arr[i]);
			tsum = arr[i];

			for (int j = 0; j < len; j++) {
				if (i == j)
					continue;

				if (tsum + arr[j] > sum) {
					continue;
				} else if (tsum + arr[j] == sum) {
					tRes.add(arr[j]);
					tRes.sort(SumMatchSubst::compare);
					if(!finalRes.contains(tRes)){
						finalRes.add(tRes);}
					break;
				}else{
					tsum += arr[j];
					tRes.add(arr[j]);
				}
			}
		}
		
		finalRes.forEach(each -> {
			each.forEach(i -> System.out.print(i+","));
			System.out.println();
		});
	}

	static int compare(Integer o1, Integer o2){

		if(o1 > o2){
			return 1;
		}else if(o1==o2){
			return 0;
		}else{
			return -1;
		}
	
	}
}
