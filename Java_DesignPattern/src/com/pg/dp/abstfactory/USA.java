package com.pg.dp.abstfactory;

import java.util.Arrays;
import java.util.List;

public class USA implements Country {
	@Override
	public List<String> getAllStates() {
	
		String[] strArr = new String[]{"florida","texas","atlanda"};
		
		return Arrays.asList(strArr);
	}
	
}
