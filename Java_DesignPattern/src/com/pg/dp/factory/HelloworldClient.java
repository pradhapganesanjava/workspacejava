package com.pg.dp.factory;

public class HelloworldClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
Helloworld helloworld =  HellowordFactory.getInstance(HelloworldFromIndia.class.getName());
		System.out.println(helloworld.sayHi());

	}

}
