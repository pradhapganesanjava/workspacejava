package com.pg.java8.api.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AnyMatchPredicate {

	static String[] strArr = { "PG", "GP", "APR", "PR", "012", "ERR", "ERROR" };
	public static void main(String[] args) {

		Predicate<String> isErr = str -> "ERROR".equalsIgnoreCase(str) || "ERR".equalsIgnoreCase(str);
		
		List<String> strLst = Arrays.asList(strArr);
		
		System.out.println(strLst.stream().anyMatch(isErr));
		
		strLst.stream().reduce((i, a) -> i + a).ifPresent(s -> System.out.println(s));
	}

}
