package com.pg.java.thread.syncimportance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkerSyncBlockAdv {

	Random rand = new Random();

	private List<Integer> listOne = new ArrayList<Integer>();
	private List<Integer> listTwo = new ArrayList<Integer>();

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		final WorkerSyncBlockAdv worker = new WorkerSyncBlockAdv();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				worker.process();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				worker.process();
			}
		});

		t1.start();
		//t2.start();

		try {

			t1.join();
			t2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// worker.process();
		long end = System.currentTimeMillis();
		System.out.println("Time consume: " + (end - start) + " milliseconds");
		System.out.println("listOne size: " + (worker.listOne.size()) + " listTwo size: "
				+ worker.listTwo.size());
	}

	public void process() {
		for (int i = 0; i < 100; i++) {
			loadListOne(rand.nextInt(1001));
			loadListTwo(rand.nextInt(1001));
		}
	}

	public void loadListOne(int lng) {
		synchronized (listOne) {
			listOne.add(lng);
		}
		goSleep(1);
	}

	public void loadListTwo(int lng) {
		synchronized (listTwo) {
			listTwo.add(lng);
		}
		goSleep(1);
	}

	private void goSleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
