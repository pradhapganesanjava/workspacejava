package com.pg.java.thread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProduceConsume {

	BlockingQueue<Integer> bQ = new ArrayBlockingQueue<>(100);

	public static void main(String... str) {

		BlockingQueueProduceConsume this_ = new BlockingQueueProduceConsume();

		Thread proThr = new Thread(this_::produce);
		Thread consThr = new Thread(this_::consume);

		proThr.start();
		consThr.start();
	}

	public void produce() {
		System.err.println("... PRODUCE RUNNING ...");
		try {
			for (int i = 0; i < 1000; i++) {
				this.bQ.put(i);
				System.out.println("..add.."+i);
			}
			System.err.println("....END... PRODUCE");
			bQ.put(-100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void consume() {
		System.err.println("... consume RUNNING ...");
		try {
			int i = bQ.take();
			while (i != -100) {
				System.out.println(i);
				i = bQ.take();
				System.out.println("....");
			}
			System.err.println("....END... CONSUME");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
