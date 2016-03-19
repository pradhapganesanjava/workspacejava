package com.pg.java.thread.hello;


public class HelloRunnable implements Runnable {

	static PingPong pingPongStatic = new PingPong();

	PingPong pingPongIns = new PingPong();
	
	public static void main(String[] args) {
		
		HelloRunnable hrun = new HelloRunnable();
		
		Thread th1 = new Thread(hrun);
		Thread th2 = new Thread(hrun);

		th1.setName("A");
		th2.setName("B");
		
		th1.start();
		th2.start();
	}

	@Override
	/*public void run() {
		pingPong.increaseCount(Thread.currentThread().getName(),1);
		
		try {
			Thread.currentThread().sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//pingPongIns.increaseCount(Thread.currentThread().getName());
	}*/
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			pingPongStatic.increaseCount(Thread.currentThread().getName(), i);

			/*try {
				Thread.currentThread().sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		
		//pingPongIns.increaseCount(Thread.currentThread().getName());
	}
}

class PingPong {

	private int count = 0;

	public int getCount() {
		return count;
	}

	public void increaseCount(String threadName) {
		for (int i = 0; i < 20; i++) {
			System.out.println(threadName + "-count: " + i);
			/*if (i == 10) {
				try {
					System.out.println("WAIT is triggered");
					Thread.currentThread().wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}*/
		}
	}

	public synchronized void increaseCount(String threadName,int i) {
			System.out.println(threadName + "-count: " + i);
	}
}