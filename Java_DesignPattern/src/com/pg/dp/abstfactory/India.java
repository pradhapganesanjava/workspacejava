package com.pg.dp.abstfactory;

import java.util.Arrays;
import java.util.List;

public class India implements Country{
 
	@Override
	public List<String> getAllStates() {
	
		String[] strArr = new String[]{"Tamilnadu","karnataka","Kerala"};
		
		return Arrays.asList(strArr);
	}
	

}
