package com.pg.algorithm.array.string;

/***
 * permutation is a rearrangement of letters 
 * 
 * @author pradhapganesan
 *
 */
public class PermutationOfString {
	static StringBuilder strBuild = new StringBuilder();
	static String inStr = "1234567890";
	static int pCount = 0;
	static int k = 3;
	public static void main(String[] args) {
		
		permutation();
		System.out.println("Permutation count: "+pCount);
	}
	
	private static void permutation(){
		if(strBuild.length() == k){
			System.out.println(strBuild.toString());
			pCount++;
			return;
		}
		for(int i=0; i<inStr.length();i++){
			if(strBuild.toString().contains(""+inStr.charAt(i))){
				continue;
			}
			strBuild.append(inStr.charAt(i));
			permutation();
			strBuild.setLength(strBuild.length()-1);
		}
	}
	
}
