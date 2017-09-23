package com.pg.dp.factory;

public class ClassForNameFactory {

	public static void main(String[] args) {
		System.out.println(ClassForNameFactoryImpl.newInstance(DummyClass.class));
		System.out.println((ClassForNameFactoryImpl.newInstance(DummyClass.class) instanceof DummyClass));
		System.out.println( ((DummyClass)ClassForNameFactoryImpl.newInstance(DummyClass.class)).population("india"));
	}

}

class DummyClass{
	String IN_POPULATION = "125 crores";
	public DummyClass(){
		System.out.println("DummyClass Constructor...");
		IN_POPULATION = "130 crores";
	}
	
	public String population(String country){
		if("india".equalsIgnoreCase(country)){
			return indiaPopulation();
		}else{
			return "Less than India";
		}
	}
	
	private String indiaPopulation(){
		return IN_POPULATION;
	}
}

class ClassForNameFactoryImpl{
	public static Object newInstance(String className){
		try {
			Class classIns = Class.forName(className);
			return classIns.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Object newInstance(Class className){
		try {
			Class classIns = Class.forName(className.getName());
			return classIns.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}