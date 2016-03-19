package com.pg.ds.map;

import java.util.TreeMap;

public class Hello_TreeMap {

	/**
	 * @param args
	 * 
	 * TreeMap by default natural key sorted
	 */
	public static void main(String[] args) {

		TreeMap<String,Object> treeMap = new TreeMap<String, Object>();
		treeMap.put("z","Z");
		treeMap.put("b","B");
		treeMap.put("a","A");
		
		System.out.println(treeMap.keySet()); //natural sorted
		

		
	}

}
