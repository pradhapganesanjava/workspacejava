package com.pg.java.string;

public class StringSplit {

	public static void main(String[] args) {

		String str = "CLIENT|CLIENT FUND CODE|DATA FEED|TRADE DATE|DIRECTION|QUANTITY";
		for(String s : str.split("|")){
			System.out.println(s);
		}
		
	}

}
