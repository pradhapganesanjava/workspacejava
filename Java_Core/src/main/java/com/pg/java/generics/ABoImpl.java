package com.pg.java.generics;

public class ABoImpl extends AbstBo{
 
	private String fName = "Pradhap";
	private String lName = "Ganesan";
	private Boolean isMale = true;
	private Long salary = 2323222L;
	
	private BBoImpl bBoImpl = new BBoImpl();
	
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
	public BBoImpl getbBoImpl() {
		return bBoImpl;
	}
	public void setbBoImpl(BBoImpl bBoImpl) {
		this.bBoImpl = bBoImpl;
	}
	
	
	
}
