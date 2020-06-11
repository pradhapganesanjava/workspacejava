package com.pg.java8.map;

import java.util.Arrays;

public class ArraysStreamMap {

	public static void main(String[] args) {
		int[] iarr = new int[] {2,3,4,5,0,-1,-9};
		System.out.println(Arrays.toString(iarr));
		Arrays.stream(iarr).map( num -> iarr[num]=-iarr[num]);
		System.err.println(Arrays.toString(iarr));
	}

}
