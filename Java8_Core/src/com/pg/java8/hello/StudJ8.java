package com.pg.java8.hello;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudJ8 {

	public static void main(String[] args) {
		
		String cstr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		List<Integer> intList = Arrays.asList(new Integer[100000]).stream().map(m->(int)(Math.random() * 100)).collect(Collectors.toList());
		//intList.forEach(System.out::println);
		
		System.out.println( intList.stream().filter(p -> (p >=80 && p <=90)).count() );
		
		List<Stud> studLst = Arrays.asList(new Stud[100000]).stream().map(m->new Stud(((int)(Math.random() * 100)),String.valueOf(cstr.charAt((int)(Math.random() * 26))))).collect(Collectors.toList());;
//		System.out.println(" studLst "+studLst);
		studLst.forEach(System.out::println);
	}

}
class Stud{
	int percentage;
	String name;
	public Stud() {
	}
	public Stud(int perc, String name){
		this.percentage = perc;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public Stud setName(String name) {
		this.name = name;
		return this;
	}
	public int getPercentage() {
		return percentage;
	}
	public Stud setPercentage(int percentage) {
		this.percentage = percentage;
		return this;
	}
	public Stud setStud(int percentage, String name) {
		this.percentage = percentage;
		this.name = name;
		return this;
	}
	public String toString(){
		return this.name+" : "+this.percentage;
	}
}