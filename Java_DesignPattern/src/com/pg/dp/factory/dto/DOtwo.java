package com.pg.dp.factory.dto;

public class DOtwo extends BO implements MOtwo{

	private Class<DTOtwo> dtoClass = DTOtwo.class;
	
	private String name;
	private int age;
	private Double salary;
	
	public DOtwo() {
		super.dtoClass = this.dtoClass;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getAge() {
		return this.age;
	}
	
	@Override
	public Double getSalary() {
		return this.salary;
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
