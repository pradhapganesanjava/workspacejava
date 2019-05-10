package com.pg.alg.bitwise;

import java.util.Random;

public class Rand7fromRand5 {

	public static void main(String[] args) {
		for(int i=0; i<7;i++) {
			int rand5 = rand5();
			int rand7 = ((5 * rand5) ^ 31)%7;
			rand7 = equallyDistribRand7();
			System.out.format("%d : %d try to distrib: %d \n", i, rand5, rand7 );
		}
	}
	
	private static int rand5() {
		//return new Random().nextInt(5);
		return (int)(Math.random()*100) % 5;
	}
	
	private static int equallyDistribRand7() {
		
		while(true) {
			int r1 = 5 * rand5() + rand5();
			if(r1<21) {
				return r1 % 7;
			}
			
		}
		
	}
}
