package com.pg.java.exception;

public class ErrorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try{
			staticMethod();
		}catch(ClassCastException te){
			System.out.println("thr err" + te.getMessage());
		}

	}

	static void staticMethod() {
		throw new Error("err message");
	}

}
