package com.pg.java.thread.wait;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * Java provided API "BlockingQueue" which is thread safe and wait-notify implicit handles in it.
 *
 */
public class BlockingQueueTest {
	private static final int LIMIT = 10;
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(LIMIT);

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

	public static void produce() throws InterruptedException{
		Random rand = new Random();
		while (true) {
			final int randInt = rand.nextInt(100);
			System.out.println("Produce: "+randInt);
			queue.put(randInt);
		}
	}

	public static void consume() throws InterruptedException {

		while (true) {
			Thread.sleep(100);
			Integer takenValue = -1;
				takenValue = queue.take();
			System.out.println("Thread:" + Thread.currentThread().getId() + " comsumed value: " + takenValue
					+ " queue size: " + queue.size());
		}
	}
}
