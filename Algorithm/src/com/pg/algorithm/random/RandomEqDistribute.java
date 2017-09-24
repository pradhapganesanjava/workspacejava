package com.pg.algorithm.random;

import java.util.Arrays;

public class RandomEqDistribute {

	private static final int MAX_PRIM_SIZE = 200;

	public static void main(String[] args) {
		
		int randNumRange = 17;
		//int primeNum = closerPrimeNum(randNumRange);
int primeNum = 7;
int primeRoot = 3;

for(int i=0; i<primeNum-1; i++){
	System.out.println(new Double(Math.pow(primeRoot+0.0, i+0.0)%primeNum).intValue());
}
	}

	private static int closerPrimeNum(int randNum){
		int[] primeArr = generatePrimeNums(null);
		System.out.print(Arrays.toString(primeArr)+"\n");
		for(int primeNum : primeArr){
			if(primeNum >= randNum){
				return primeNum;
			}
		}
		return 0;
	}
	private static int[] generatePrimeNums(int[] primeNumArr) {
		if(null == primeNumArr){
			primeNumArr = new int[MAX_PRIM_SIZE];
		}
		int primeIndxCount = 0;
		int count = 2;
		while (primeIndxCount < MAX_PRIM_SIZE ){
			boolean primeFound = true;

			if (count < 4) {
				primeNumArr[primeIndxCount] = count;
				primeIndxCount++;
				count++;
				continue;
			}
			int j = 0;
			while (j < primeIndxCount) {
				if ((count % primeNumArr[j]) == 0) {
					primeFound = false;
					break;
				}
				j++;
			}
			if (primeFound) {
				primeNumArr[primeIndxCount] = count;
				primeIndxCount++;
			}
			count++;
		}
		return primeNumArr;
	}

}
