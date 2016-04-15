package com.pg.java.generics;

public class BBoImpl extends AbstBo{
 
	private String fName = "Rajini";
	private String lName = "Kamal";
	private Boolean isMale = false;
	private Long salary = 0L;
	
	public String getfName() {
		return fName;
	}
	public String getlName() {
		return lName;
	}
	public Boolean getIsMale() {
		return isMale;
	}
	public Long getSalary() {
		return salary;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public void setIsMale(Boolean isMale) {
		this.isMale = isMale;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
	
}
