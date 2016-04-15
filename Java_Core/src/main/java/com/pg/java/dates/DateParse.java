package com.pg.java.dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParse {

	public static void main(String...strings){
		try{
			//Date dt = new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2999");
			
			//2014-09-17 16:26:14.0
			Date dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-09-17 16:26:14.0");
			//DateFormat.parse("2014-09-17 16:26:14.0");
			System.out.println("date dt "+dt.toString());
		}catch(ParseException e){
			System.out.println(" not able to populate expiration date " + e.getMessage());
		}
	}
	
}
