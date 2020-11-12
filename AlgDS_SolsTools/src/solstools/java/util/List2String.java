package solstools.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List2String {

	public static void main(String[] args) {
		
		int ni = Integer.MIN_VALUE;
		int pi = Integer.MAX_VALUE;

		System.out.println(((long)ni)-((long)pi));
		List<String> slst = new ArrayList<>();
		
		slst.add("A");
		slst.add("B");
		slst.add("C");
		slst.add("X");
		
		String s = Arrays.toString( slst.toArray());
		System.out.println(s);
		
		StringBuilder strb = new StringBuilder();
		slst.forEach( ech -> {
			strb.append(ech);
			strb.append(",");
		});
		s = strb.toString();
		System.out.println(s);
	}

}
