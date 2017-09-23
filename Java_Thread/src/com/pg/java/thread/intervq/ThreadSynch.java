package com.pg.java.thread.intervq;

/*
 * Aithor Anish Nath
 */
public class ThreadSynch implements Runnable {
	private String name;

	public ThreadSynch(String name) {
		this.name = name;

		new Thread(this).start();
	}

	public void run() {
		while (true) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}

				System.out.println(name + " ");
			}
		}
	}
	
	public static void main(String[] args) {

		ThreadSynch threads[] = new ThreadSynch[3];
		
		for (int i = 0; i < 3; ++i)
		{
			threads[i] = new ThreadSynch("T"+i);
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

