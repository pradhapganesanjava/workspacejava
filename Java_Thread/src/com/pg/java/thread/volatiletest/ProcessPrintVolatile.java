package com.pg.java.thread.volatiletest;

import java.util.Scanner;

public class ProcessPrintVolatile {

	public static void main(String[] args) {
		processPrint();
	}

	private static void processPrint() {
		Processor processT1 = new Processor();
		Processor processT2 = new Processor();

		processT1.start();
		processT2.start();

		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		processT1.stopPrint();
		// processT2.stopPrint();
	}
}

class ProcessorService {

	private static boolean printOn = true;
	private int counter = 0;

	public void setPrintOn(boolean printOn) {
		ProcessorService.printOn = printOn;
	}

	public void printHi() {
		System.out.println(Thread.currentThread().getId() + ": Hi...." + counter++);
	}

	public boolean getPrintOn() {
		return ProcessorService.printOn;
	}
}

class Processor extends Thread {

	/*
	 * Declaring a variable as volatile (be it static or not) states that the
	 * variable will be accessed frequently by multiple threads.
	 */
	volatile ProcessorService processSrv = new ProcessorService();

	@Override
	public void run() {
		while (processSrv.getPrintOn()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			processSrv.printHi();
		}
	}

	public void stopPrint() {
		this.processSrv.setPrintOn(false);
	}
}