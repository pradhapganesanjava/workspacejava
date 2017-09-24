package com.pg.dp.factory;

public class HellowordFactory {
	//HellowordFactory INSTANCE = HellowordFactoryHelper.getInstance("HelloworldImpl");
 public static Helloworld getInstance(String className){
	try {
		return (Helloworld) ClassLoader.getSystemClassLoader().loadClass(className).newInstance();
	} catch (InstantiationException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return null;}
}
