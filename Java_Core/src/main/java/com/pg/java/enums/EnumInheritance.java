package com.pg.java.enums;

public class EnumInheritance {

}

class EnumInheritanceExmpl {

public enum Status {
	STATUS_OPEN {
		public String description() {
			return "open";
		} },
	STATUS_STARTED {
		public String description() {
			return "started";
		} },
	STATUS_INPROGRESS {
		public String description() {
			return "inprogress";
		} },
	STATUS_COMPLETED {
		public String description() {
			return "completed";
		} };

	Status() {
	}

	public abstract String description();
}

	public static void main(String[] args) {
		for(Status stat : Status.values()){
			System.out.println(stat + " desc is " + stat.description());
		}
	}

}