package com.pg.alg.seq.missing.array.binarystr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Find the missing element in an array of integers represented in binary format

Examples:

Input: arr[] = {“0000”, “0001”, “0010”, “0100”}
Output: 3

Input: arr[] = {“0000”, “0001”, “0010”, “0011”, “0100”, “0110”, “0111”, “1000”}
Output: 5

 */
public class Missing1Num_NShuffleUniqueBinaryString {

	public static void main(String[] args) {
		String strArr[] = {"0000", "0001", "0010", "0100"};
		Integer[] iarr = {1, 2, 4};
		List<Integer> inLst = new ArrayList<Integer>(Arrays.asList(iarr));
		int missV = 0;
		missV = findMissingRecur(inLst, 0);
		System.out.println("Missing num in binary " + missV);
	}

	private static int findMissingRecur(List<Integer> inLst, int idx) {
		
		if(idx >= Integer.SIZE ) return 0;
		
		List<Integer> bits0 = new ArrayList<>(inLst.size()/2+1);
		List<Integer> bits1 = new ArrayList<>(inLst.size()/2+1);
		
		for(Integer in : inLst) {
			//System.out.format(" idx: %d, in: %d, 1 lfsft idx : %s, ( 1 lf idx) nd in : %d \n", idx, in, Integer.toBinaryString((1 << idx)), ((1 << idx)&in));
			if( ((1 << idx) & in ) > 0) {
				bits1.add(in);
			}else {
				bits0.add(in);
			}
		}
		
		System.out.println("");
		if(bits0.size() <= bits1.size()) {
			int v = findMissingRecur(bits0, idx+1);
			//return  v | 0;
			System.out.format("bits0 idx: %d returning  v lfsft 1 : %s (v << 1) | 0 : %s \n", idx, Integer.toBinaryString((v << 1)), Integer.toBinaryString((v << 1) | 0));
			return  (v << 1) | 0;
		}else {
			int v = findMissingRecur(bits1, idx+1);
			//return  v | 1 << idx;
			System.out.format("bits1 idx: %d returning  v lfsft 1 : %s (v << 1) | 1 : %s \n", idx, Integer.toBinaryString((v << 1)), Integer.toBinaryString((v << 1) | 1));
			return  (v << 1) | 1;
		}
	}

	private static char[] noviceWayNotwork(String[] strArr) {
		int cnt0 = 0;
		int cnt1 = 0;
		int len = strArr[0].length();
		int lsb =  len - 1;
		for(String str : strArr) {
			if(str.charAt(lsb) == '0') {
				cnt0 ++;
			}else {
				cnt1++;
			}
		}
		
		boolean isOddMiss = true;
		if(cnt1 <= cnt0) {
			isOddMiss = false;
		}
		char[] missNumArr = new char[len];
		missNumArr[lsb] = isOddMiss ? '1' : '0';
		lsb--;
		while(lsb >= 0) {
			cnt0 = 0;
			cnt1 = 0;			
			for(String str : strArr) {
				if( (isOddMiss && str.charAt(lsb) == '0') 
						|| (!isOddMiss && str.charAt(lsb) == '1')) {
					continue;
				}
				if(str.charAt(lsb) == '0') {
					cnt0 ++;
				}else {
					cnt1++;
				}
			}
			// missNumArr[lsb] = cnt1 >= cnt0 ? '0' : '1';
			missNumArr[lsb] = cnt0 <= cnt1 ? '0' : '1';
			if( cnt0 <= cnt1) {
				isOddMiss = false;
			}else {
				isOddMiss = true;
			}
			lsb--;
		}
		return missNumArr;
	}

}
