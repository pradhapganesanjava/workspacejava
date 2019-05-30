package com.pg.algorithm.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PerfectShufleCards {

	public static void main(String[] args) {
		
		System.out.println(generateRandom(5, 5));
		System.out.println(generateRandom(4, 5));
		System.out.println(generateRandom(2, 5));
		
		List<Integer> resLst = new ArrayList<>();
		perfectShufle(1,10,resLst);
		System.out.println("resLst "+resLst.size());
		resLst.forEach(ech -> System.out.print(ech + ", "));
		
		perfectShuffleStressTest();
	}

	private static void perfectShufle(int st, int ed, List<Integer> resLst) {
		if(st > ed) return;
		
		int rand = generateRandom(st, ed);
		//System.out.format("st: %d, ed: %d, rand: %d \n", st, ed, rand );
		resLst.add(rand);
		
		perfectShufle(st, rand-1, resLst);
		perfectShufle(rand+1, ed, resLst);
		
	}

	private static int generateRandom(int st, int ed) {
		if(st == ed) return st;
		Random randObj = new Random();
		//int ied = randObj.nextInt(ed - st);
		int ied = (int)(Math.random() * (ed - st + 1));
		int rand = st + ied;
		return rand;
	}
	
	private static void perfectShuffleStressTest() {
		int testSize = 10000;
		List<List<Integer>> lolst = new ArrayList<>();
		int[] tot = new int[10];

		for (int i = 0; i < testSize; i++) {
			List<Integer> resLst = new ArrayList<>();
			perfectShufle(0, 9, resLst);
			
			for(int j=0; j<10; j++) {
				if(j==resLst.get(j)) {
					tot[j] += 1;
				}
			}
			
		}
		
		for(int i=0; i<10; i++) {
			System.out.println(tot[i]);
			System.out.format("i: %d percentage : %f", i, ( (tot[i]+0.0)/testSize)*100.0);
		}
	}

}
