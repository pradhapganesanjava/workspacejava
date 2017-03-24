package com.pg.dp.factory.dto;

public class DTOtwo extends BO implements MOtwo {

	private String name;
	private int age;
	private Double salary;	
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public Double getSalary() {
		return this.salary;
	}
	
	@Override
	public int getAge() {
		return this.age;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
