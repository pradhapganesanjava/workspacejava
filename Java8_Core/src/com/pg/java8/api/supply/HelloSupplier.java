package com.pg.java8.api.supply;

import java.util.Random;
import java.util.function.Supplier;

public class HelloSupplier {

	public static void main(String[] args) {
		int i = 0;
		printSupplier(HelloSupplier::genRandInt);
	}
	
	public static void printSupplier(Supplier<Integer> supplyInt){
		System.out.println(supplyInt.get());
	}
	
	public static int genRandInt(){
		return new Random().nextInt();
	}
	
}
