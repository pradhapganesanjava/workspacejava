package com.pg.java.convert;

public class StringToDoubleConvert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String intStr = "1";
		String floatStr = "1.1f";
		String doubleStr = "1.1";
		
		Double dblWrp_intStr = new Double(intStr);
		Double dblWrp_floatStr = new Double(floatStr);
		Double dblWrp_doubleStr = new Double(doubleStr);
		//Double dblWrp_intStr = new Double(intStr);
		
		System.out.println(" dblWrp_intStr> "+dblWrp_intStr);
		System.out.println(" dblWrp_floatStr> "+dblWrp_floatStr);
		System.out.println(" dblWrp_doubleStr> "+dblWrp_doubleStr);
		
	}

}
