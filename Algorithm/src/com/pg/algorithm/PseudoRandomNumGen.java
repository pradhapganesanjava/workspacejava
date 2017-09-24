package com.pg.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

public class PseudoRandomNumGen {

	
	
	public static void main(String[] args) {
		/*MyRandom randGen = new MyRandom();
		for(int i=0;i<20;i++){
			System.out.println(randGen.nextRand());
		}*/

//		PseudoRandomNumGen.MyRandomInt randIntGen = new PseudoRandomNumGen().new MyRandomInt();
		MyRandomInt_Out randIntGen = new MyRandomInt_Out(10);
		for(int i=0;i<100;i++){
			System.out.println(randIntGen.nextRand());
		}
	}

	private static class MyRandom{
		int digit = 4;
		AtomicInteger seed;
		
		public MyRandom() {
			seed = new AtomicInteger();
			seed.set(12321);
		}
		
		public int nextRand(){
			int multSeed = (seed.get() * seed.get());
			String multSeedStr = String.valueOf(multSeed);
			while(multSeedStr.length() < digit*2){
				multSeedStr="0"+multSeedStr;
			}
			int start = multSeedStr.length()/2;
			int end = start + digit;
			
			multSeedStr = multSeedStr.substring(start, end);
			seed.set(Integer.parseInt(multSeedStr));
			return seed.get();
		}
		
	}
	
	static class MyRandomInt{
		int digit = 4;
		int seed;
		int mod = 0;
		
		public MyRandomInt() {
			seed = 1234;
		}
		public MyRandomInt(int mod) {
			seed = 1234;
			this.mod = mod; 
		}
		public int nextRand(){
			int multSeed = (seed * seed);
			String multSeedStr = String.valueOf(multSeed);
			while(multSeedStr.length() < digit*2){
				multSeedStr="0"+multSeedStr;
			}
			int start = multSeedStr.length()/2;
			int end = start + digit;
			
			multSeedStr = multSeedStr.substring(start, end);
			seed = Integer.parseInt(multSeedStr);
			if(mod > 0){
				seed = seed % mod;
			}
			return seed;
		}
	}

}

class MyRandomInt_Out{
	int digit = 10;
	int seed;
	int mod = 0;
	
	public MyRandomInt_Out() {
		seed = 1234567890;
	}
	public MyRandomInt_Out(int mod) {
		seed = 1234567890;
		this.mod = mod; 
	}
	public int nextRand(){
		int multSeed = (seed * seed);
		String multSeedStr = String.valueOf(multSeed);
		while(multSeedStr.length() < digit*2){
			multSeedStr="0"+multSeedStr;
		}
		int start = multSeedStr.length()/2;
		int end = start + digit;
		
		multSeedStr = multSeedStr.substring(start, end);
		seed = Integer.parseInt(multSeedStr);
		/*if(mod > 0){
			seed = seed % mod;
		}*/
		return seed;
	}
}

