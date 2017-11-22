package com.pg.java.enums;

public class EnumImplementsInterf {

}


enum Currency2 implements Runnable {
	PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
	private int value;
	private Currency2(int val) {
		this.value = val;	}

	@Override
	public void run() {
		System.out.println("Enum in Java implement interfaces");}
}