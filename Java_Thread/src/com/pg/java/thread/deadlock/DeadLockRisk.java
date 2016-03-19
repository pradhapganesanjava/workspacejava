package com.pg.java.thread.deadlock;

public class DeadLockRisk {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final DeadLockRisk dlRiskIns = new DeadLockRisk();
		
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				dlRiskIns.write();
				System.out.println(Thread.currentThread().getId()+": read "+dlRiskIns.read());
			}
		};

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				dlRiskIns.write();
				System.out.println(Thread.currentThread().getId()+": read "+dlRiskIns.read());
			}
		};

		Runnable r3 = new Runnable() {
			@Override
			public void run() {
				dlRiskIns.write();
				System.out.println(Thread.currentThread().getId()+": read "+dlRiskIns.read());
			}
		};

		new Thread(r1).start();
		new Thread(r2).start();
		new Thread(r3).start();
		
	}
	
	private static class Resource{
		int value;
	}

	private Resource resourceA = new Resource();
	private Resource resourceB = new Resource();
	
	public int read(){
		synchronized(resourceA){ // May deadlock here
			synchronized (resourceB) {
				return 	resourceB.value+resourceA.value;
			}
		}
	}
	
	public void write() {
		synchronized (resourceB) { // May deadlock here
			synchronized (resourceA) {
				resourceA.value=100;
				resourceB.value=200;
			}
		}
	}
}
