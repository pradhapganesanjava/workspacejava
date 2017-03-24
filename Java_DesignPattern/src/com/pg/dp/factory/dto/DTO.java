package com.pg.dp.factory.dto;

public class DTO extends BO implements MO {

	private String name;
	private int age;
	private Double salary;	
	
	private MOtwo mOtwo;
	
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
	
	@Override
	public MOtwo getMOtwo() {
		return this.mOtwo;
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

	public void setMOtwo(MOtwo mOtwo) {
		this.mOtwo = mOtwo;
	}
	
}
