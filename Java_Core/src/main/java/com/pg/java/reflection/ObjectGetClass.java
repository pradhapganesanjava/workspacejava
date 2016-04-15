package com.pg.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ObjectGetClass {

	public static void main(String... str) {

		Myclass myclass = new Myclass("Pradhap","Ganesan");
		checkClass(myclass);
		
	}
	
	static void checkClass(Object myclass){
		System.out.println(myclass.getClass());
		System.out.println(myclass.getClass().getName());
		System.out.println(myclass.getClass().getDeclaredFields()[0].getType());
		System.out.println("int type " + myclass.getClass().getDeclaredFields()[2].getType().isPrimitive());
		System.out.println(" boolean type "+ myclass.getClass().getDeclaredFields()[3].getType().toString()+" ? "+(myclass.getClass().getDeclaredFields()[3].getType().toString().equals("boolean")));
		
		
		System.out.println(myclass.getClass().getDeclaredFields()[1].getName());
		System.out.println(myclass.getClass().getDeclaredMethods()[0]);
		
		String fieldName = myclass.getClass().getDeclaredFields()[0].getName();
		
		StringBuilder strBuild = new StringBuilder("get");
		System.out.println(" substring(1,1) "+fieldName.substring(0,1));
		System.out.println(" substring(2,fieldName.length()-1) "+fieldName.substring(1));
		strBuild.append(fieldName.substring(0,1).toUpperCase());
		strBuild.append(fieldName.substring(1));
		
		String getterM = strBuild.toString();
		System.out.println("getter me "+getterM);
		
		try {
			
			Object objRes = myclass.getClass().getMethod(getterM).invoke(myclass);
			System.out.println("objRes "+objRes);
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

}

class Myclass {
	private String myName;
	private String myLName;
	private int Age;
	private boolean single;
	
	public Myclass() {
	}
	
	public Myclass(String myName, String myLname) {
		this.myName = myName;
		this.myLName = myLname;
	}
	
	public String getMyName() {
		return myName;
	}

	public String getMyLName() {
		return myLName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public void setMyLName(String myLName) {
		this.myLName = myLName;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public boolean isSingle() {
		return single;
	}

	public void setSingle(boolean single) {
		this.single = single;
	}
}
