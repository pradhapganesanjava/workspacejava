package com.pg.java.string;

import java.util.Arrays;

import com.sun.xml.internal.ws.util.StringUtils;

public class StringFormat {

	/*
	 *  %s - String
	 *  %d - decimal integer (NOT Double)
	 *  %tD - date as MM/dd/yy; %td-day; %tm - month; %ty -yy(year); %tY-yyyy(year)
	 *  %f - float
	 *  %n - new line 
	 */
	public static void main(String[] args) {


		/**
		 * String.format "%[argument number] [flags] [width] [.precision] type
		 *        format("%,6.2f", 124.000)
		 *  6-width
		 *  .2-decimal points
		 *  type-float
		 *  
		 *  "%X" - int to hex
		 */
		Double dDbl = 10.100;
		float flt = 244.000f;
		String formattedOne = String.format("%,1.3f", dDbl);
			System.out.println(" formattedOne "+formattedOne);
		
		formattedOne = String.format("%1.0f", dDbl);//truncate decimals
			System.out.println(" formattedOne "+formattedOne);

			
			String string = "I love INDIA";
			char[] charArr = string.toCharArray();
			
			System.out.println(" Reversed  ");
	}

}
