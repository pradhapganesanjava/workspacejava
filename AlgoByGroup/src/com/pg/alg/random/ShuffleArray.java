package com.pg.alg.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleArray {

	public static void main(String[] args) {
		char[] charr = new char[] {'A','B', 'C', 'D', 'E'};
		System.out.println("INPUT: ");
		print(charr);
		shuffle_array_test(charr);
		
		shuffle_permute_test(charr);
	}
	private static void shuffle_permute_test(char[] charr) {
		int shuffle_cnt = 3;
		int cnt = shuffle_cnt % charr.length;
		List<List<Character>> lolst = new ArrayList<>();
		List<Character> lst = IntStream.range(0, charr.length).mapToObj(i -> charr[i]).collect(Collectors.toList());
		for(int i=0; i<cnt; i++) {
			shuffle_permute(charr,lst);
		}
	}
	private static void shuffle_permute(char[] charr, List<Character> lst) {
		//shuffle_permute_recur(0, charr,)
	}
	private static void shuffle_array_test(char[] charr) {
		for(int i=0; i<3; i++) {
			char[] cparr = charr.clone();
			shuffle_random(cparr);
			System.out.format("After Shuffle: ");
			print(cparr);
		}
	}
	private static void print(char[] charr) {
		for(char c : charr) {
			System.out.format("%c ,",c);
		}
		System.out.println();
	}
	private static void shuffle_random(char[] charr) {
		System.out.format("---------------------- \n Input B4 Shuff: ");
		print(charr);
		int ed = charr.length - 1;
		for(int i=0; i<ed; i++) {
			int ri = -1;
			if (ed - i > 1) {
				while (i == (ri = randRange(i, ed))) {
				}
			} else {
				ri = ed;
			}
			char ich = charr[i];
			charr[i] = charr[ri];
			charr[ri] = ich;
		}		
	}
	private static int randRange(int st, int ed) {
		Random random = new Random();
		
		int ri = st+random.nextInt(ed-st);
		System.out.format("s: %d, e: %d = rand: %d \n", st, ed, ri);
		return ri;
	}
}
