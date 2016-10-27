package com.pg.parse;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Pattern;

public class Convert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double unitDataInt = 1590;
		double dbl = unitDataInt / 1024;
		
		System.out.println(""+dbl);
		
		DecimalFormat df = new DecimalFormat("##.#");
		String formDF = df.format(unitDataInt / 1024);
		String unitData = String.valueOf(formDF + " GB");

		System.out.println(unitData);
	}

}
