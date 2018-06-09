package com.pg.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetIntSort {

	public static void main(String[] args) {
		Set<Integer> iSet = new HashSet<>();
		iSet.add(3);
		iSet.add(10);
		iSet.add(11);
		iSet.add(1);
		iSet.add(13);
		
		List<Integer> iLst = new ArrayList<>(iSet);
		Collections.sort(iLst);
		
		System.out.println(iLst);
		
		
		
	}

}
