package com.pg.java8.methodref;

public class ConstructorMethodRef {

	public static void main(String[] args) {

		PersonFactory<Person> personFactoryMr = (n, a, ad) -> new Person(n, a, ad);
		Person personMr = personFactoryMr.createPerson("Pradhap", 22, "constructor");

		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.createPerson("Ganesan", 10, "constructor");
	}

}

interface PersonFactory<P extends Person> {
	P createPerson(String name, int age, String address);
}

class Person {
	String name = "N/A";
	Integer age = 0;
	String address = "No address provided";

	Person(String name, int age, String addrs) {
		this.name = name;
		this.age = age;
		this.address = addrs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}