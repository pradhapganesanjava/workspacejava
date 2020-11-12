package com.pg.java8.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapCompute {

	public static void main(String[] args) {
		Map<Integer, Set<Integer>> mp = new HashMap<>();
		mp.compute(1, (k,v) ->{
			if(v==null) {
				v = new HashSet<Integer>();
			}
			v.add(1);
			return v;
		});
		int num = 13;
		for(int i=1; i<100;i++) {
			num = i;
			//System.out.println(Math.log(num));
			int lg = ((int) Math.floor(logBase2(num)));
			int rem = num - (int)Math.pow(2, lg);
			System.out.format("(%f) %d = %d + %d \n",logBase2(num), num, lg, rem);
		}
		int[] nums = new int[]{1,2,4,7};
		Arrays.sort(nums, nums.length-1, 0);
		System.out.println(Arrays.toString(nums));
				
	}
	private static double logBase2(int num) {
		return (Math.log(num))/Math.log(2);
	}

}
