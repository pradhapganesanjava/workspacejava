package com.pg.alg.bitwise;

public class HammingWeight_1BitsCount {

	public static void main(String[] args) {
		int n = 11;
		System.out.format("%d bis => %s , bits count: %d \n", n, Integer.toBinaryString(n), hammingWeight(11) );
		String str = "11111111111111111111111111111101";
		
		double lng = 0l;
		for(int i=31; i>=0; i--) {
			if(str.charAt(i) == '1') {
				lng += (Math.pow(2, 31-i));
			}
		}
		// System.out.format("str: %s, int: %d ", str, Integer.parseUnsignedInt(str, 2));
		System.out.format("str: %s, int: %f ", str, lng);
	}

	public static int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32; i++){
        		
            if( (n & (1 << i) ) > 0  ){
            	System.out.format("i: %d, bi => %s , n & bi: %s \n", i, Integer.toBinaryString((1<<i)), Integer.toBinaryString(n & 1 << i));
                count++;
            }
        }
        return count;
    }
}
