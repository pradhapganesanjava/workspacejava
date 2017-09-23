package com.pg.java.thread.daemon;

import java.util.Scanner;

public class HelloDaemonThread {
	static int count = 0;
	public static void main(String[] args) {

		Thread daemonT1 = new Thread( new Runnable() {
			@Override
			public void run() {
				while(true){
					System.out.println("DaemonT1 thread running..."+count++);
				}
			}
		});
		daemonT1.setDaemon(true);
		daemonT1.start();
		
		//look for user input
		//waitForUserInput();
		
		mainDaemonThreadSleep(5);
		System.err.println();
		System.err.println("main daemon ENDs");
		System.err.println("daemonT1 daemon ENDs\n");
	}
	private static void waitForUserInput() {
		System.out.println("main - daemon thread wait for input... ");
		Scanner scan = new Scanner(System.in);
		String userInData = scan.nextLine();
		System.out.println("Please enter customer data "+userInData);
	}
	private static void mainDaemonThreadSleep(long milliSeconds) {
		System.out.println("mainDaemonThreadSleep for "+milliSeconds);
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
