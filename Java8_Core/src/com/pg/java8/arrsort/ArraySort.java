package com.pg.java8.arrsort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraySort {

	public static void main(String[] args) {
		int[] nums = new int[] {3,1,5,8,10,2};
        List<Integer> ilst = IntStream.of(nums).boxed().sorted((i1, i2) -> {
            return i1-i2;
        }).collect(Collectors.toList());
        ilst.forEach(ech -> System.out.print(ech + ","));
	}

}
