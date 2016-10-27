package com.pg.util;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayUtil {

	public static void main(String[] args) {

		ArrayList<String> temp = new ArrayList<String>();
		temp.addAll(Arrays.asList(args));
		temp.addAll(Arrays.asList(args));
		String [] concatedArgs = temp.toArray(new String[args.length+args.length]);
	}

	
}
