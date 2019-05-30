package com.pg.alg.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupNFreqNames {

	public static void main(String[] args) {

		HashMap<String, Integer> names = new HashMap<String, Integer>();

		names.put("John", 3);
		names.put("Jonathan", 4);
		names.put("Johnny", 5);
		names.put("Chris", 1);
		names.put("Kris", 3);
		names.put("Brian", 2);
		names.put("Bryan", 4);
		names.put("Carleton", 4);

		String[][] synonyms = { { "John", "Jonathan" }, { "Jonathan", "Johnny" }, { "Chris", "Kris" },
				{ "Brian", "Bryan" } };

		List<Set<String>> synLst = new ArrayList<>();
		

		for (int r = 0; r < synonyms.length; r++) {
			boolean found = false;
			for (Set<String> st : synLst) {
				if (st.contains(synonyms[r][0])) {
					st.add(synonyms[r][1]);
					found = true;
				} else if (st.contains(synonyms[r][1])) {
					st.add(synonyms[r][0]);
					found = true;
				}
			}

			if (!found) {
				Set<String> st = new HashSet<>();
				st.add(synonyms[r][0]);
				st.add(synonyms[r][1]);
				synLst.add(st);
			}
			

		}

		List<Integer> freqLst = new ArrayList<>(synLst.size());
		synLst.forEach( ech ->{
			freqLst.add(0);
		});
		
		for (String name : names.keySet()) {
			Integer freq = (Integer) names.get(name);
			for (int i = 0; i < synLst.size(); i++) {
				Set<String> st = synLst.get(i);
				if (st.contains(name)) {
						Integer oldV = freqLst.get(i);
						Integer nwV = oldV + freq;
						freqLst.set(i, nwV);
						break;
				}
			}
		}

		Map<String, Integer> resMp = new HashMap<>();
		for (int i = 0; i < synLst.size(); i++) {
			Set<String> st = synLst.get(i);
			String name = null;
			if (null != st && !st.isEmpty() && st.iterator().hasNext()) {
				name = st.iterator().next();
			}
			if (null != name && !"".equals(name)) {
				Integer freq = freqLst.get(i);
				resMp.put(name, freq);
			}
		}

		System.out.println(resMp);
	}

}
