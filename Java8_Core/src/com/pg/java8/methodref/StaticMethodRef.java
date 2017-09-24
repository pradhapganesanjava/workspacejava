package com.pg.java8.methodref;

public class StaticMethodRef {
	public static void main(String[] args) {

		Converter<String, Integer> convertStrToInt = (str) -> Integer.valueOf(str);
		Converter<String, Integer> convertStrToIntMr = ConverterImpl::stringToInteger;

		convertStrToInt.convert("111");
		convertStrToIntMr.convert("222");
	}  }

class ConverterImpl {
	public static Integer stringToInteger(String s) {
		return Integer.valueOf(s);}

	public static Double stringToDouble(String s) {
		return Double.valueOf(s);
	} }

interface Converter<F, T> {
	T convert(F from);}