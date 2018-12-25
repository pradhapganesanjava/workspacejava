package com.pg.algorithm.array.integer.sort;

import java.util.Arrays;
import java.util.Scanner;

public class LastIndexOfDuplicate {

	static int[] iarr = { 0, 1, 2, 2, 4, 5, 5, 5, 7, 8 };
	static int in = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.err.format("Input Arr: %s \n Input finding num: ", Arrays.toString(iarr));
			String in1 = scan.nextLine();
			try {
				in = Integer.parseInt(in1);
			} catch (NumberFormatException e) {
				System.out.println("...Exit...");
				break;
			}
			int indxFound = findLastInxOfDups();
			System.out.format("Find %d in Arr: %s . Found %d \n\n", in, Arrays.toString(iarr), indxFound);
		}
	}

	static int findLastInxOfDups() {
		int indx = -1;
		int lo = 0;
		int hi = iarr.length - 1;
		while (lo <= hi) {
			int md = (lo + hi) / 2;
			if (iarr[md] == in) {
				lo = md + 1;
				indx = md;
			} else if (in > iarr[md]) {
				lo = md + 1;
			} else {
				hi = md - 1;
			}
		}

		return indx;
	}

}
