package com.pg.java.thread.syncimportance;


public class Counter {

	private int counter = 0;
	
	public static void main(String[] args) {
		Counter countObj = new Counter();
		countObj.counterTest();

	}

	private void counterTest() {
		Runner r = new Runner(this);
		Thread runT1 = new Thread(r);
		Thread runT2 = new Thread(r);
		
		runT1.setName("A");
		runT2.setName("B");
		
		runT1.start();
		runT2.start();
		
		try{
			runT1.join();
			runT2.join();
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("CURRENT THREAD: "+Thread.currentThread().getName());
		System.out.println(" counter : "+this.getCounter());
	}

	public synchronized int incrementCount(){
		return this.counter++;
	}
	
	public int getCounter() {
		return counter;
	}
}


class Runner implements Runnable{
	
	private Counter counter = null;
	
	public Runner() {
	}

	public Runner(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		System.out.println("CURRENT THREAD: "+Thread.currentThread().getName());
		for(int i=0;i<1000;i++){
			counter.incrementCount();
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}