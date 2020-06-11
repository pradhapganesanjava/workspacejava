package com.pg.alg.slidingwindow;

import java.util.Arrays;

/**
 * 
 * Majority Element: A majority element is an element that makes up more than
 * half of the items in an array. Given a positive integers array, find the
 * majority element. 
   If there is no majority element, return-1. Do this in O(N) time and 0(1) space. 
   
   EXAMPLE 
    Input: { 1, 2, 5, 9, 5, 9, 5, 5, 5}
    Output: 5
 *
 */

/*
 * Novice: HashMap and count or O(n^2) 
 * Slidewindow: count, majority additional local variable helps to figure this out
 */
public class MajorityNum {

	public static void main(String[] args) {

		int[] iarr = { 1, 2, 5, 9, 5, 9, 5, 5, 5};
		System.out.format("InArr: %s, major: %d \n",Arrays.toString(iarr), majorNum(iarr));
		
	}

	private static int majorNum(int[] iarr) {
		int major = -1;
		int count = 0;
		for(int ival : iarr) {
			if(count == 0) {
				major = ival;
			}
			if(ival == major) {
				count++;
			}else {
				count--;
			}
		}
		count = 0;
		for(int ival : iarr) {
			if(ival == major) {
				count++;
			}
		}
		
		 return count > iarr.length/2 ? major : -1;
	}

}
