package com.pg.java.thread.wait;

import java.util.LinkedList;
import java.util.Random;

public class PublishSubcribePattern {

	public static void main(String[] args) {

		final PublishSubcribePattern pubsubObj = new PublishSubcribePattern();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pubsubObj.publish();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pubsubObj.subscribe();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}

	private volatile LinkedList<Integer> intLlist = new LinkedList<Integer>();
	//we have locker object bacause, when intLlist object can be come null or reasigned then will loose lock. 
	private final Object lockerObj = new Object();
	final int LIMIT = 10;
	
	public void publish() throws InterruptedException {
		Random rand = new Random();
		while (true) {
			synchronized (lockerObj) {
				while (intLlist.size() == LIMIT) {
					lockerObj.wait();					
				}
				intLlist.add(rand.nextInt(100));
				lockerObj.notify();
			}
		}
	}
	
	public void subscribe() throws InterruptedException{

		while (true) {
			synchronized (lockerObj) {
				while (intLlist.size() == 0) {
					lockerObj.wait();
				}
				System.out.println("list size: "+intLlist.size());
				int removedVal = intLlist.removeFirst();
				System.out.println("list size: "+intLlist.size()+" removed val: "+removedVal);
				lockerObj.notify();
			}
		}
	}

}
