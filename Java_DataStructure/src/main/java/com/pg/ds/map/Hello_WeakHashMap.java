package com.pg.ds.map;

import java.util.Map;
import java.util.WeakHashMap;

public class Hello_WeakHashMap {

	/**
	 * @param args
	 * 
	 * Elements in a weak hashmap can be garbage collected, if no strong ref to the object.
	 * useful for Cache/Lookup storage.
	 * lifetime of cache entries is determined by reference to the key not value.
	 * 
	 * > Key wrapped in java.lang.ref.WeakReference : 
	 * 
	 */
	public static void main(String[] args) {


		Map<String,Object> weakMap = new WeakHashMap<String, Object>();

	}

}
