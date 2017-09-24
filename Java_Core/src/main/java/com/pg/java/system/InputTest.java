package com.pg.java.system;

import java.io.IOException;

public class InputTest {

	public static void main(String[] args) {

		//getInputChar();
		getInputStr();

	}

	
	private static void getInputChar() {
		try {
			System.out.print("Please enter char input :");
			//Read char and return 0 - 255
			int intInput = System.in.read();
			System.out.println("System.in.read read first char, return b/w (0-255). charInput : " + intInput);
		} catch (IOException e) {	e.printStackTrace();	}
	}

	private static void getInputStr() {
		try {
			System.out.print("Please enter String input :");
			byte[] charSeq = new byte[200];
			//Read sequence of chars
			int intStatus = System.in.read(charSeq);
			System.out.println("\nSystem.in.read(byte[]) read charSeq, return 0 or -1. charSeqInput : " + new String(charSeq));
			System.out.println("charSeqInput : " + new String(charSeq));
		} catch (IOException e) {	e.printStackTrace();	}
	}
}
