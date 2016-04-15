package com.pg.java.thread.blockqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueHello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BlockingQueue<String> bQueue = new ArrayBlockingQueue<String>(10);

		Thread t1 = new Thread(new ProducerRun(bQueue));
		Thread t2 = new Thread(new ConsumerRun(bQueue));
		
		t1.start();
		t2.start();
	}
}

class ProducerRun implements Runnable {

	private BlockingQueue<String> queue;

	public ProducerRun(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Random rand = new Random();
		boolean run = true;
		while (run) {
			String randStr = Integer.toString(rand.nextInt(10));
			queue.add(randStr);
			System.out.println(" Queue UPDATED "+ randStr+" size " + queue.size());
			if (queue.size() == 10) {
				run = false;
			}
		}
	}
}

class ConsumerRun implements Runnable {

	private BlockingQueue<String> queue;

	public ConsumerRun(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Random rand = new Random();
		boolean run = true;
		while (run) {
			try {
				String str = queue.take();
				System.out.println("TAKEN " + str + " Queue size " + queue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(queue.size()==0){
				run=false;
			}
		}
	}
}