package com.pg.java8.lambda;

public class LamdaThread {

	public static void main(String[] args) {

		String name = "Pradhap";

		Runnable runIntf = null;

		/*runIntf = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("Welcome " + name);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Hello  " + name);
			}
		};*/

		runIntf = () -> {
			try {
				Thread.sleep(1000);
				System.out.println("Welcome " + name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Hello  " + name);
		};

		new Thread(runIntf).start();

	}

}
