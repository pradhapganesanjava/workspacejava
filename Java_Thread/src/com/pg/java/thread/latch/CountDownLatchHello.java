package com.pg.java.thread.latch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchHello {

	/**
	 * @param args
	 * 
	 *1) You can not reuse CountDownLatch once count is reaches to
	 *zero
	 * 
	 *2) Thread(main) calls await(), will wait until other
	 *thread calls CountDownLatch.countDown() to inform that they
	 *have completed.
	 * 
	 */
	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(3);

		Thread initTr = new InitThread(latch);
		Thread validateTr = new ValidateThread(latch);
		Thread authTr = new AuthorizeThread(latch);
		Thread authenTr = new AuthenticateThread(latch);

		initTr.start();
		validateTr.start();
		authTr.start();
		authenTr.start();

		try {
			authenTr.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("ALL PROCESS DONE !!!");
	}
}

class AuthenticateThread extends Thread {
	private CountDownLatch latch;

	public AuthenticateThread(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			System.out.println("AuthenticateThread waiting latch countdown to complete... ");
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" Authenticate are COMPLETE ");
		// this thread informs/update to decrement the latch count
	}
}

class AuthorizeThread extends Thread {
	private CountDownLatch latch;

	public AuthorizeThread(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println(" Authorizations are COMPLETE ");
		// this thread informs/update to decrement the latch count
		latch.countDown();
	}
}

class ValidateThread extends Thread {
	private CountDownLatch latch;

	public ValidateThread(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println(" Validations are COMPLETE ");
		// this thread informs/update to decrement the latch count
		latch.countDown();
	}
}

class InitThread extends Thread {
	private CountDownLatch latch;

	public InitThread(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println(" Initializations are COMPLETE ");
		// this thread informs/update to decrement the latch count
		latch.countDown();
	}

}