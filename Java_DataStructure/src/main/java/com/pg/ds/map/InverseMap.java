package com.pg.ds.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class InverseMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<String, String> orgMap = new HashMap<String, String>();

		orgMap.put("Paul", "P");
		orgMap.put("Tom", "T");
		orgMap.put("Apple", "A");
		orgMap.put("Xavior", "X");
		orgMap.put("Antony", "Z");

		Map<String, String> lhMap = new LinkedHashMap<String, String>(sortByValue(orgMap));
		for (String key : lhMap.keySet()) {
			System.out.println(lhMap.get(key));
		}

		// Map<String, Set<String>> inversMap = inverseMapImpl(orgMap);

	}

	private static <K, V> Map<K, V> sortByValue(final Map<K, V> map) {
		Comparator<K> compare = new Comparator<K>() {
			public int compare(K k1, K k2) {
				String value1 = (String) map.get(k1);
				String value2 = (String) map.get(k2);
				int compare = value1.compareTo(value2);
				/*if (compare < 0)
					return -1;*/
				 if (compare == 0)
					return 1;
				else
					return compare;
				//return compare;
			}
		};
		Map<K, V> sortedMap = new TreeMap<K, V>(compare);
		sortedMap.putAll(map);

		return sortedMap;
	}
}
