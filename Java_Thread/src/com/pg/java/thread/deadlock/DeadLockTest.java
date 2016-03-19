package com.pg.java.thread.deadlock;

public class DeadLockTest {

	public static void main(String[] args) {

		new Thread_A().start();
		new Thread_B().start();
		new Thread_C().start();
		new Thread_D().start();
		
	}

}

class Thread_A extends Thread{
	@Override
	public void run() {
		new Class_A().process(); 
	}
}

class Thread_B extends Thread{
	@Override
	public void run() {
		new Class_B().process(); 
	}
	
}

class Thread_C extends Thread{
	@Override
	public void run() {
		new Class_C().process(); 
	}
	
}

class Thread_D extends Thread{
	@Override
	public void run() {
		new Class_D().process(); 
	}
	
}


class Class_A{
	private Class_B bIns = new Class_B();
	void process(){
		System.out.println("Processing A");
		bIns.process();
	}
}

class Class_B{
	
	private Class_C cIns = new Class_C();
	void process(){
		System.out.println("Processing B");
		cIns.process();
	}
}

class Class_C{
	
	private Class_D dIns = new Class_D();
	void process(){
		System.out.println("Processing C");
		dIns.process();
	}
}

class Class_D{
	
	private Class_B bIns = new Class_B();
	void process(){
		System.out.println("Processing D");
		bIns.process();
	}
}