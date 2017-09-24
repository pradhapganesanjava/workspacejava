package com.pg.java.thread.daemon;

import java.util.Scanner;

public class DaemonVsUserThread {
	static boolean stop = false;
	static int userCount = 0;
	public static void main(String[] args) {
		int count = 0;
		System.out.println("user runs... ");
		Thread userT1 = new Thread( new Runnable() {
			@Override
			public void run() {
				while(!stop){
					System.out.println("I am user thread run until inputs : "+userCount++);
					if(userCount>500000){
						break;
					}
				}
			}
		});
		userT1.start();
		
		//look for user input
		System.out.println("main - daemon thread wait for input... ");
		Scanner scan = new Scanner(System.in);
		String userInData = scan.nextLine();
		System.out.println("Please enter customer data "+userInData);
		if(null!=userInData){
			DaemonVsUserThread.stop=true;
		}
		
		Thread daemonT1 = new Thread( new Runnable() {
			@Override
			public void run() {
				while(true){
					System.out.println("I am daemonT1 thread "+userCount++);
				}
			}
		});
		daemonT1.setDaemon(true);
		daemonT1.start();
		
		System.out.println("main daemon ENDs");
		System.out.println("daemonT1 daemon ENDs");
	}

}
