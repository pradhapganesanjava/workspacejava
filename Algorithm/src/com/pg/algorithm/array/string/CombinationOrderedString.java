package com.pg.algorithm.array.string;

import java.util.HashSet;
import java.util.Set;

public class CombinationOrderedString {
	static String inStr=null;
	static StringBuilder cStrBuild = new StringBuilder();
	static StringBuilder pStrBuild = new StringBuilder();
	static Set<String> pTestSet = new HashSet<String>();
	static int cCount = 0;
	static int pCount = 0;
	public static void main(String[] args) {
		inStr = "abcd";
		combination(0);
		System.out.println("combination count: "+cCount);
		/*permutation();
		System.out.println("permutation count: "+pCount);
		System.out.println("test permutation count: "+pTestSet.size());*/
	}
	
	private static void combination(int start){
		for(int i=start; i< inStr.length(); ++i ){
			cStrBuild.append(inStr.charAt(i));
			System.out.println(cStrBuild);
			cCount++;
			//to maintain the order not to shuffle
			combination(i+1);
			
			//NOT to handle same char - skip the char
			cStrBuild.setLength(cStrBuild.length() - 1);
		}
	}
	private static void permutation(){
		for(int i=0; i< inStr.length(); ++i ){
			//Does not maintain the order
			if(pStrBuild.toString().contains(""+inStr.charAt(i))) continue;
			
			pStrBuild.append(inStr.charAt(i));
			
			//permutation 
			if(pStrBuild.length() == inStr.length()){
				System.out.println(pStrBuild);
				pTestSet.add(pStrBuild.toString());
				pCount++; }				
			
			permutation();
			//NOT to handle same char - skip the char
			pStrBuild.setLength(pStrBuild.length() - 1);
		}
	}
}
