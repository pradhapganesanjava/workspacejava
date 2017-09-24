package com.pg.algorithm.array.integer;

public class FindMinNumCoins {

	public static void main(String[] args) {

		int[] denoms = {1,2,5,10,20,50,100,500,1000};
		int amt1 = 93;
		int amt2 = 121;
		int amt3 = 1513224;
		
		findMinNumCoinsImpl(denoms, amt1);
		/*findMinNumCoinsImpl(denoms, amt2);
		findMinNumCoinsImpl(denoms, amt3);*/

	}

	private static void findMinNumCoinsImpl(int[] denoms, int amount){
		
		if(amount == 0) return;
		
		int closestDenom = getClosestDenoms(denoms,amount);
		int denomCount = amount / closestDenom;
		amount = amount % closestDenom;
		
		System.out.println("Denom: "+closestDenom+" : count "+denomCount);
		
		findMinNumCoinsImpl(denoms,amount);
	}
	
	private static int getClosestDenoms(int[] denoms, int amount){
		
		
		if(amount > denoms[denoms.length-1]){
			return denoms[denoms.length-1];
		}
		
		int left = 0;
		int right = denoms.length -1;
		int mid = 0;
		
		while(left <= right){
			mid = left + (left+right)/2;
			if(denoms[mid]==amount){
				break;
			}
			if(denoms[mid]>amount){
				right = mid-1;
			}else{
				left = mid +1;
			}
		}
		
		if(amount > denoms[mid] && amount < denoms[mid-1]){
			mid = mid-1;
		}
			
		return denoms[mid];
	}
}
