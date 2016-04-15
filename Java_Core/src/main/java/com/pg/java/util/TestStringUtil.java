package com.pg.java.util;


public class TestStringUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// testIsNotBlankInArray();
		testGetSubString();
	}

	public static void testGetSubString(){
		
		String mdn1 = "X1234567890";
		String mdn2 = "1234567890";
		String mdn3 = "123456789";
		String mdn4 = "XY1234567890";
		
		 System.out.println(mdn1+"=>"+getSubString(mdn1, 10));
		 System.out.println(mdn2+"=>"+getSubString(mdn2, 10));
		 System.out.println(mdn3+"=>"+getSubString(mdn3, 10));
		 System.out.println(mdn4+"=>"+getSubString(mdn4, 10));
	}
	
	public static String getSubString(String inputStr, int lastChars) {
		if(inputStr.length()<=10) return inputStr;
		int beginIndex = inputStr.length() - lastChars;
		int endIndex = inputStr.length();

		return inputStr.substring(beginIndex, endIndex);
	}

	private static void testIsNotBlankInArray() {
		System.out.println(" " + isNotBlankInArray());
		System.out.println(" " + isNotBlankInArray(""));
		System.out.println(" " + isNotBlankInArray(null));
		System.out.println(" " + isNotBlankInArray("A", ""));
		System.out.println(" " + isNotBlankInArray("A", null));
		System.out.println(" " + isNotBlankInArray("A", "B"));
	}

	/**
	 * 
	 * @param strVarArg
	 * @return boolean
	 * 
	 *         StringUtil.isNoBlankInStrArr() - return false;
	 *         StringUtil.isNoBlankInStrArr("") - return false;
	 *         StringUtil.isNoBlankInStrArr(null) - return false;
	 *         StringUtil.isNoBlankInStrArr("A","") - return false;
	 *         StringUtil.isNoBlankInStrArr("A",null) - return false;
	 *         StringUtil.isNoBlankInStrArr("A","B") - return true;
	 */
	public static boolean isNotBlankInArray(String... strVarArg) {
		if (null == strVarArg || strVarArg.length == 0) {
			return false;
		}
		for (int index = 0; index < strVarArg.length; index++) {
			try {

				if (!"".equals(strVarArg[index]))
					continue;
				else
					return false;

			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}
}
