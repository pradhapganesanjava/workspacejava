package com.pg.java.inherit;

public class InheritTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A abc = new B();
		abc.sayHello();
		
		int x = 0;
		int y = x;
		x = 2;
		System.out.println("x :"+x+" y:"+y);
		
		for (int i=0; i< 10; i++){
			System.out.println(i);
		}
				
	}
	

}

class A {
	public A() {
		sayHello();
	}

	public void sayHello()

	{
		System.out.println("A ");
	}
}

class B extends A {
	private final int x;

	public B() {
		x =3;
	}

	public void sayHello()

	{
		System.out.println("A " + x);
	}
}