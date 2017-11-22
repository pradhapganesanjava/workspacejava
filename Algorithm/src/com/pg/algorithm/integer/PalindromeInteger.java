package com.pg.algorithm.integer;

public class PalindromeInteger {

	public static void main(String[] args) {

		int inint = 102301;
//		int inint2 = 3300222111;
		int iTmp = 0;
		int il = inint;
		while(il>iTmp){
			iTmp = (iTmp * 10) + (il % 10);
			il = il / 10;
		}
		
		if(il==iTmp || il == iTmp/10){
			System.out.println("Palindrome");
		}

		System.out.println(iTmp);

	}

}
