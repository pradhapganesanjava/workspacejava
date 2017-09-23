package com.pg.java.annotat;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class HelloAnnotation {


	public static void main(String[] args) {

		Developer dev = new Developer();
		System.out.println(" des " +dev.designation );
		
		Class devClass = dev.getClass();
		
		Annotation an = devClass.getAnnotation(EmpDesign.class);
		EmpDesign empDIns = (EmpDesign)an;
		System.out.println( empDIns.designation() );
		
		
	}

}

@EmpDesign(designation="DEV")
class Developer extends EmpAnnotate{
}

class EmpAnnotate{
	protected String designation = "employee"; 

	public EmpAnnotate() {
	}
	
	public EmpAnnotate(String design){
		this.designation = design;
	}
	
	public String salary(){
		switch(designation){
		case "DEV":
			return "85K";
		case "SDEV":
			return "95K";
		case "JMAN":
			return "90K";
		case "MAN":
			return "100K";
		case "SMAN":
			return "110K";
		}
		
		return "N/A";
	}

	public void setDesignation() {
		this.designation = "NA";
	}
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface EmpDesign{
	String designation() default "NA";
}
