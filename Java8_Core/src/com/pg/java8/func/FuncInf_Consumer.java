package com.pg.java8.func;

import java.util.Arrays;
import java.util.function.Consumer;

public class FuncInf_Consumer {

	public static void main(String[] args) {

		Consumer<String> consStr = (s)->System.out.println(s);
		consStr.accept("pg");
		consStr.accept("gp");
	}

}
