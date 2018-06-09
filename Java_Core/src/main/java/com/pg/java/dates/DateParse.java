package com.pg.java.dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParse {

	public static void main(String...strings) throws ParseException{

		System.out.println(convertDate("02/04/2018", "MM/dd/YYYY"));
		System.out.println(convertDate("02/04/2018", "MM/dd/yyyy"));		
		System.out.println(convertDate("02/04/2018", "mm/dd/YYYY"));
		System.out.println(convertDate("02/04/2018", "mm/dd/yyyy"));
		
		//timestampConvert();
	}

	private static void timestampConvert() {
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
	
	public static Date convertDate(String strdate, String pattern) throws ParseException {
		if (null == strdate)
			return null;
		if ("" == pattern || null == pattern)
			pattern = "yyyymmdd";

		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat(pattern);

		try {
			date = format.parse(strdate);
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}
}
