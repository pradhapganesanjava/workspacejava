package com.pg.java.operator;

public class InstanceOfTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "PRADHAP";
		String strNull = "null";
		Object objStr1 = new String("something");
		Object objStr2 = null;

		System.out.println("Object objStr1 = new String(..) objStr1 instanceof String ?"+ (objStr1 instanceof String));
		System.out.println("Object objStr2 = null objStr2 instanceof String ?"+ (objStr2 instanceof String));
		
		if (str instanceof String)
			System.out.println("str " + str);

		if (strNull instanceof String)
			System.out.println("strNull " + strNull);
	}

}
