package com.pg.java.enums;

public class EnumWithParameters {

}

class EnumWithMethods {

public enum Status {
	STATUS_OPEN(0, "open"), 
	STATUS_STARTED(1, "started"), 
	STATUS_INPROGRESS(2, "inprogress"), 
	STATUS_COMPLETED(4, "completed"); 

	private final int status;
	private final String description;

	Status(int aStatus, String desc) {
		this.status = aStatus;
		this.description = desc; }

	public int status() {
		return this.status;}

	public String description() {
		return this.description; }
}

public static void main(String[] args) {
	for(Status stat : Status.values()){
		System.out.println(stat + "value is " + new Integer(stat.status()) + " desc is "
				+ stat.description());
	}
}
}