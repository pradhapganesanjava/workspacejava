package com.pg.java.thread.intervq;

import java.util.ArrayList;
import java.util.List;

/*
 * Author Anish Nath
* visit the channel http://youtube.com/zarigatongy
 */
public class ThreadSynchV2 implements Runnable {
	private String name;
	private List<String> list;

	public ThreadSynchV2(List<String> name) {
		this.list = name;

		new Thread(this).start();
	}

	public void run() {
		while (true) {
			synchronized (this) {
				for (String s : list) {
					try {
						wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					System.out.println(s);
				}

			}
		}
	}

	public static void main(String[] args) {

		ThreadSynchV2 threads[] = new ThreadSynchV2[3];

		List<String> l1 = new ArrayList<String>();
		l1.add("A");
		l1.add("B");
		l1.add("C");
		List<String> l2 = new ArrayList<String>(l1);
		List<String> l3 = new ArrayList<String>(l1);

		for (int i = 0; i < 3; ++i) {
			if (i == 0) {
				threads[i] = new ThreadSynchV2(l1);
			}
			if (i == 1) {
				threads[i] = new ThreadSynchV2(l2);
			}
			if (i == 2) {
				threads[i] = new ThreadSynchV2(l3);
			}

			// threads[i] = new ThreadSynchV2("t"+i);
		}
		int index = 0;
		while (true) {
			synchronized (threads[index]) {
				threads[index].notify();
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			index = (++index) % 3;
		}

	}
}
