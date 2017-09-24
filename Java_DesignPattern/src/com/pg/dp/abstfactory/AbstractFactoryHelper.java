package com.pg.dp.abstfactory;

public class AbstractFactoryHelper {

	private static String prefixClass = "Abstract";

	private AbstractFactoryHelper() {
	}

	public static <T> T createFactoryInstance(Class<T> className) {

		ClassLoader classLoader = FactoryHelper.getClassLoader();
		T factoryInstance = null;

		if (null == classLoader) {
			return null;
		}
		String fullClassName = prefixClass + className;

		try {
			Class loadedClass = classLoader.loadClass(fullClassName);
			factoryInstance = (T) loadedClass.newInstance();

		} catch (ClassNotFoundException e) {
			System.out.println("Exception in Loading Class " + fullClassName);
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return factoryInstance;
	}
}
