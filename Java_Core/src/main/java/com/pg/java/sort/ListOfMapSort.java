package com.pg.java.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfMapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Map<String, Object>> myList = new ArrayList<Map<String, Object>>();

		Map<String, Object> mp1 = new HashMap<String, Object>();
		Map<String, Object> mp2 = new HashMap<String, Object>();
		Map<String, Object> mp3 = new HashMap<String, Object>();

		mp1.put("flag", "true");
		mp1.put("1_TRUE", "TRUE");

		mp2.put("flag", "false");
		mp2.put("1_FALSE", "false");

		mp3.put("flag", "true");
		mp3.put("2_TRUE", "TRUE");

		myList.add(mp1);
		myList.add(mp2);
		myList.add(mp3);
		
		Collections.sort(myList,new ListOfMapComparator());

		for(int i=0;i<myList.size();i++){
			System.out.println(myList.get(i).toString());
		}
	}

}

class ListOfMapComparator implements Comparator<Map<String, Object>> {
	@Override
	public int compare(Map<String, Object>o1, Map<String, Object> o2) {
		if (null == o1 || null == o2) {
			return -1;
		}
		/*if(((String)o1.get("flag")).compareTo((String)o2.get("flag"))){
			return 1;
		}*/
		
		if(o1.get("flag").equals("true"))
		{
			return -1;
		}else if(o1.get("flag").equals("false")){
			return 1;
		}
		return 0;
	}
}
