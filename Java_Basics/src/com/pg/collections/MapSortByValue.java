package com.pg.collections;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class MapSortByValue {

	public static void main(String... str) {

		/*TreeMap<String, String> treemap = new TreeMap<String, String>();

		treemap.put("1", "A");
	    treemap.put("2", "B");
	    treemap.put("3", "Z");
	    treemap.put("4", "X");
	    treemap.put("5", "G");
	     
	    Map sortedMap = sortByValuesStr(treemap);
	     
	    */
	    
		TreeMap<String, Map> treemap = new TreeMap<String, Map>();
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("expiry_date","10/01/2015");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("expiry_date","11/11/2015");

		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("expiry_date","09/09/2015");

		Map<String, String> map4 = new HashMap<String, String>();
		map4.put("expiry_date",null);

		Map<String, String> map5 = new HashMap<String, String>();
		map5.put("expiry_date","12/12/2015");

		treemap.put("1", map1);
	    treemap.put("2", map2);
	    treemap.put("3", map3);
	    treemap.put("4", map4);
	    treemap.put("5", map5);
	    
	    
	    Map sortedMap = sortByValuesMap(treemap);
	    
	 // Get a set of the entries on the sorted map
	    Set set = sortedMap.entrySet();
	 
	    // Get an iterator
	    Iterator i = set.iterator();
	 
	    // Display elements
	    while(i.hasNext()) {
	      Map.Entry me = (Map.Entry)i.next();
	      System.out.print(me.getKey() + ": ");
	      System.out.println(me.getValue());
	    }
	}

	public static <K, V extends Comparable<V>> Map<K, V> sortByValuesStr(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {

				int compare = map.get(k1).compareTo(map.get(k2));
				if(compare == 0) return 1;
				else return compare;

			}

		};
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	public static <K, V> Map<K, V> sortByValuesMap(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = -1;
				/*
				 * int compare = map.get(k1).compareTo(map.get(k2)); if(compare
				 * == 0) return 1; else return compare;
				 */
				if(map.get(k1) instanceof Map && map.get(k2) instanceof Map){
					Map k1Map = (Map) map.get(k1);
					Map k2Map = (Map) map.get(k2);

					Date k1ExpiryDate = null;
					Date k2ExpiryDate = null;

					String k1Expiry_date = (String) k1Map.get("expiry_date");
					if(k1Expiry_date != null && !"".equals(k1Expiry_date)){
						k1ExpiryDate = stringToDate(k1Expiry_date, "MM/dd/yyyy");
					}else{
						try{
							k1ExpiryDate = new SimpleDateFormat("MM/dd/yyyy").parse("01/01/1900");
						}catch(ParseException e){ System.out.println("parser exception "+e.getMessage());
						}
					}

					String k2Expiry_date = (String) k2Map.get("expiry_date");
					if(k2Expiry_date != null && !"".equals(k2Expiry_date)){
						k2ExpiryDate = stringToDate(k2Expiry_date, "MM/dd/yyyy");
					}else{
						try{
							k1ExpiryDate = new SimpleDateFormat("MM/dd/yyyy").parse("01/01/1900");
						}catch(ParseException e){System.out.println("parser exception "+e.getMessage());
						}
					}

					//compare = k1ExpiryDate.compareTo(k2ExpiryDate);
					compare = k2ExpiryDate.compareTo(k1ExpiryDate);
				}
				if(compare == 0) return 1;
				else return compare;
				
				/*if(compare > 0) return 1;
				else return compare;*/
				
				//return compare;
			}
			
			
		};
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}
	
	/*public static <K, V> Map<K, V> sortByValues2(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k1).compareTo(map.get(k2));
				if(compare == 0) return 1;
				else return compare;
			}
		};
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return;
	}*/
	
	public static final Date stringToDate(String date, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		
		Date result = null;
		
		try {
			result = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
