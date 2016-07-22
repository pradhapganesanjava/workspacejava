package com.pg.ds.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetHello {

	private Set<String> setStr = new HashSet<String>();
	
	public SetHello(String[] arrStr) {
		setStr = new HashSet<String>(Arrays.asList(arrStr));
	}
	
	public static void main(String[] args) {

		String[] arrStr = new String[]{"A","B","C","D","Z"};
		SetHello thisIns = new SetHello(arrStr);
		
		//HashSet can have null value
		thisIns.setStr.add(null);

		//Set can NOT have duplicate value; means it overrides without exception
		thisIns.setStr.add("A");

		//Iterate Set
		int count=0;
		for(String str:thisIns.setStr){
			System.out.println(count+":"+str);
			count++;
		}

	}
}
