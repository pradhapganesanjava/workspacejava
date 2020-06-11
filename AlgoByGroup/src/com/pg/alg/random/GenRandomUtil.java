package com.pg.alg.random;

import java.util.Random;

public class GenRandomUtil {

	public static void main(String[] args) {
		
		System.out.println(genRandRange(0, 1));
		System.out.println(genRandRange(5, 8));
		System.out.println(genRandRange(6, 6));
	}

	private static int genRandRange(int lf, int rt) {
		if (lf == rt)
			return lf;
		Random rand = new Random();
		return lf + rand.nextInt(rt - lf);
	}

}
