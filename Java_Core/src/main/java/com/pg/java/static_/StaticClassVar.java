package com.pg.java.static_;

public class StaticClassVar {

	public static void main(String[] args) {

		System.out.println(" " + new CountTest().getCount());
		System.out.println(" " + new CountTest().getCount());
		System.out.println(" " + new CountTest().getCount());

		System.out.println(" " + new CountSubTest1().getCount());
		System.out.println(" " + new CountSubTest2().getCount());
		System.out.println(" " + new CountSubTest1().getCount());
		System.out.println(" " + new CountSubTest2().getCount());
		System.out.println(" " + new CountSubTest1().getCount());

	}

}

class CountTest {
	// this variable if its not static then work as counter per JVM; otherwise
	// create one for every instance
	static int nextInt = 1;
	private final int count;

	public CountTest() {
		this.count = nextInt++;
	}

	public int getCount() {
		return count;
	}
}

class CountSubTest1 extends CountTest {

	public CountSubTest1() {
		super();
	}

	public int test() {
		return 0;
	}
}

class CountSubTest2 extends CountTest {

	public CountSubTest2() {
		super();
	}

	public int test() {
		return 0;
	}
}