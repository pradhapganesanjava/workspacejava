package com.pg.java8.exception;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;

public class MultiExceptionHandle {

	public static void main(String[] args) {
		invokeExceptionMethod("10.22");
	}

	private static void invokeExceptionMethod(String parse) {
		try {
			Number num = NumberFormat.getNumberInstance().parse(parse);
			System.out.println(num.intValue());
			
			File f = new File("");
			FileReader fread = new FileReader(f);  

		} catch (ParseException | NumberFormatException e) {
		} catch (FileNotFoundException | RuntimeException e) {
		}
	}

}


