package com.pg.dp.abstfactory;


public class FactoryHelper {

	public static <T>T getInstance(Class<T> classname) {

		ClassLoader classLoader = getClassLoader();
		try {
			if (null == classLoader) {
				return null;
			}
			return (T)classLoader.loadClass(classname.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ClassLoader getClassLoader() {
		// Try with the Thread Context Loader.
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();

		if (null == classLoader) {
			// get the classloader that loaded this class.
			classLoader = ClassLoader.class.getClassLoader();
		}
		if (null == classLoader) {
			classLoader = ClassLoader.getSystemClassLoader();
		}
		return classLoader;
	}
}
