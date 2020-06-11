package com.pg.alg.array.path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *  Permutation order matters.
 *  Ex: 1,2,3 != 2,1,3
 *     n!
 * _________
 *  (n - k)!
 *  
 *  
 *  Combination (like set) order does not matters; 
 *  Ex: 1,2,3 == 3,2,1
 *     n!
 * _________
 *  k! (n-k)!
 *   
 *  n is total number of elements
 *  k is number of places 
 *  
 *  #of Permutation >> #of Combination
 *
 */
public class Permute_Array {
	static AtomicInteger atomi = new AtomicInteger(0);
	static AtomicInteger atomi_uni_k = new AtomicInteger(0);
	public static void main(String[] args) {
		
		int[] iarr = new int[] { 1,2,3,4};
		
		recur(iarr);
		System.err.format("Input: %s  Flat Permut# : %d \n",Arrays.toString(iarr), atomi.get());
	}

	private static void recur(int[] iarr) {
		List<Integer> ilst = new ArrayList<>();
		// recur_dups_k(iarr, ilst);
		int[] ibuf = new int[iarr.length];
		recur_uni_k(iarr, ilst, ibuf);
		System.err.format("Input: %s  Flat Permut# : %d \n",Arrays.toString(iarr), atomi_uni_k.get());
		
	}

	private static void recur_uni_k(int[] iarr, List<Integer> ilst, int[] ibuf) {
		if(ilst.size()==iarr.length) {
			System.out.println(ilst.stream().map(String::valueOf).collect(Collectors.joining(",")));
			return;			
		}
		for(int i=0; i<iarr.length; i++) {
			atomi_uni_k.incrementAndGet();
			if( ibuf[i] == 1) continue;
			ibuf[i] = 1;
			ilst.add(iarr[i]);
			recur_uni_k(iarr, ilst, ibuf );
			ilst.remove(ilst.size()-1);
			ibuf[i] = 0;
		}
		
	}

	private static void recur_dups_k(int[] iarr, List<Integer> ilst) {
		if(ilst.size() == iarr.length) {
			System.out.println(ilst.stream().map(String::valueOf).collect(Collectors.joining(",")));
			return;
		}
		for(int i=0; i<iarr.length; i++) {
			atomi.getAndIncrement();
			ilst.add(iarr[i]);
			recur_dups_k(iarr, ilst);
			ilst.remove(ilst.size()-1);
		}
	}

}
