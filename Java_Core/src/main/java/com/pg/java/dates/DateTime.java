package com.pg.java.dates;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTime {

	public static void main(String...str){
		
		Date currentDate = Calendar.getInstance(Locale.US).getTime();
		
		System.out.println(" current date and time: "+DateFormat.getInstance().format(currentDate)); 
		
	}
}
