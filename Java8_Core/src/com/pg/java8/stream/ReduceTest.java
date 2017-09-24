package com.pg.java8.stream;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {

	public static void main(String[] args) {

		List<Person> lstPerson = Arrays.asList(new Person("Arun", 33, "M")
												, new Person("Maya", 18, "F")
												,new Person("Arti", 25, "F")
												, new Person("John", 20, "M"));

		//average method IntStream - reduction operation
		System.out.println("Calculate average age of Male Person: " + 
							lstPerson.stream()
								.filter(pMale -> "M".equals(pMale.getSex()))
								.mapToInt(pMale -> pMale.getAge()).average().getAsDouble());
		
		//General reduction operation - reduce - can NOT do average calculation
		//reduce method takes two parameters 
		int sumOfAge = lstPerson.stream()
				.filter(pMale -> "F".equals(pMale.getSex()))
				.map(pMale -> pMale.getAge()).reduce(0,ReduceTest::reduceAvg);
		
		System.out.println("Total ages of Female: "+sumOfAge);
	
		//General reduction operation - collect - can do average calculation
		double avgAge = 0.0;
		/*avgAge = lstPerson.stream()
				.filter(pMale -> "F".equals(pMale.getSex()))
				.map(pMale -> pMale.getAge()).collect(0,0,0);*/
		
		System.out.println("Avg ages of Female: "+avgAge);

	
	}
	
	private static Integer reduceAvg(Integer a, Integer b){
		return a + b;
	}

}

class Person {

	private String name;
	private int age;
	private String sex;

	public Person(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}