package com.pg.java8.api.completfuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HelloCompletableFuture {
	
	private int genRandomInt(){
		return new Random().nextInt();
	}
	
	public CompletableFuture<Integer> supplyRandInt(){
		return CompletableFuture.supplyAsync(this::genRandomInt);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		HelloCompletableFuture this_ = new HelloCompletableFuture();
		CompletableFuture<Integer> cf = this_.supplyRandInt();
		System.out.println("1" + cf.get());
		System.out.println(cf.isDone());
		cf.complete(-100);
		System.out.println("2" + cf.get());
		System.out.println("3" + cf.get());
		
	}
}
