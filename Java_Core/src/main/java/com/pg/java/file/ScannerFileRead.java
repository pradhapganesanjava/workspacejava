package com.pg.java.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileRead {

	public static void main(String[] args) {

		try {
			Scanner scan = new Scanner(new File("C:/Users/pg38446/Desktop/Tmp/personalProf.csv"));
			scan.useDelimiter(",");
			while(scan.hasNext()){
				System.out.println(scan.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
