package com.pg.java8.interf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortWithComparator {

	public static void main(String[] args) {

		List<Integer> intLst = Arrays.asList(3,2,3,1,4,5);
		Comparator<Integer> compare = (obj1, obj2) -> {
			if(obj1 > obj2){
				return 1;
			}else if(obj1==obj2){
				return 0;
			}else{
				return -1;
			}
		};
		intLst.sort(compare);
		System.out.println(Arrays.toString(intLst.toArray()));
		
	}

}
