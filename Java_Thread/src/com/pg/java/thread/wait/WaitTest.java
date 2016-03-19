package com.pg.java.thread.wait;

public class WaitTest {

	public static void main(String[] args) {

		final WaitTest waitObj = new WaitTest();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					waitObj.publish();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					waitObj.subscribe();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}

	public void publish() throws InterruptedException {
		synchronized (this) {
					System.out.println("publish: INVOKED. lock obtained");
					System.out.println("publish: releasing lock");
			long start = 0;
			long end = 0;
			start = System.currentTimeMillis();
			this.wait();
			end = System.currentTimeMillis();

					System.out.println("publish: resumed after wait : " + (end - start) + " milliseconds");
			this.notify();
		}
	}

	public void subscribe() throws InterruptedException {
		synchronized (this) {
				System.out.println("subscribe: INVOKED. lock obtained");
				System.out.println("subscribe: releasing lock");
			Thread.sleep(1000);
			this.notify();
			Thread.sleep(1000);
				System.out.println("subscribe: done");

		}
	}
}
