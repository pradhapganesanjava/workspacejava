package com.pg.java.thread.hello;

public class HelloThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyThread myThread1 = new MyThread();
		MyThread myThread2 = new MyThread();
		MyThread myThread3 = new MyThread();

		myThread1.setName("Thread_A");
		myThread2.setName("Thread_B");
		myThread3.setName("Thread_C");
		
		myThread1.start();
		myThread2.start();
		myThread3.start();
		
		try {
			System.out.println(" myThread1 join ");
			myThread1.yield();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


class MyThread extends Thread{
	//Thread currentThread = this.currentThread();
	//String threadName = currentThread.getName();
	
	@Override
	public void run() {
		//threadName = String.valueOf(currentThread.getId());
		synchronized (this) {
			for (int count = 0; count < 50; count++) {
				System.out.println(this.currentThread().getName() + " : " + count);
				if (count == 25) {
					if ("Thread_C".equals(this.currentThread().getName())) {
						System.out.println(this.currentThread().getName() + " JOINED ");
						try {
							this.currentThread().join();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else if ("Thread_B".equals(this.currentThread().getName())) {
						System.out.println(this.currentThread().getName() + " JOINED ");
						try {
							this.currentThread().join();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
}