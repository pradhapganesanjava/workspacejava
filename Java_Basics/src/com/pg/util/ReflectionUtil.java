package com.pg.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public class ReflectionUtil {

	//private ConcurrentHashMap<Integer, String> recursiveGenStrMap = new ConcurrentHashMap<Integer, String>(); 

	public static boolean isComplexInstance(Class instanceClass) {
		return !(isSimpleInstanceof(instanceClass) || isCollectionInstance(instanceClass));
	}	
	
	public static boolean isCollectionInstance(Class instanceClass) {
		return List.class == instanceClass
				|| ArrayList.class == instanceClass
				|| Set.class == instanceClass
				|| HashSet.class == instanceClass
				|| SortedSet.class == instanceClass				
				|| Map.class == instanceClass
				|| HashMap.class == instanceClass				
				|| SortedMap.class == instanceClass				
				|| Collection.class == instanceClass
				;
	}
	
	public static boolean isSimpleInstanceof(Class instanceClass) {
		return String.class == instanceClass
				|| Character.class == instanceClass
				|| Byte.class == instanceClass
				|| Short.class == instanceClass
				|| Integer.class == instanceClass
				|| Long.class == instanceClass
				|| Float.class == instanceClass 
				|| Double.class == instanceClass
				|| BigDecimal.class == instanceClass
				|| BigInteger.class == instanceClass
				|| Date.class == instanceClass
				|| Timestamp.class == instanceClass
				;
	}
	
	public static boolean isSimpleInstanceof(Object getMethodObj) {
		return getMethodObj instanceof String
				|| getMethodObj instanceof Integer
				|| getMethodObj instanceof Long
				|| getMethodObj instanceof Float
				|| getMethodObj instanceof Double
				|| getMethodObj instanceof Date
				|| getMethodObj instanceof java.sql.Timestamp
				;
	}

	public static boolean isCollectionInstance(Object getMethodObj) {
		return getMethodObj instanceof List
				|| getMethodObj instanceof Set
				|| getMethodObj instanceof Map
				|| getMethodObj instanceof Collection
				;
	}
	
	public static Field[] getAllFields(Object sourceObj) {
		
		if(null == sourceObj){return null;}
		
		Field[] privateFields= sourceObj.getClass().getDeclaredFields();
		Field[] publicFields= sourceObj.getClass().getFields();
		
		for(Field prvField : privateFields){
			System.out.println(" prvField : " + prvField.getName());
		}
		for(Field pubField:publicFields){System.out.println(" publicFields : "+pubField.getName());}
		
		ArrayList<Field> tempArray = new ArrayList<Field>();
		if(null != privateFields && privateFields.length > 0){
			tempArray.addAll(Arrays.asList(privateFields));
		}
		if(null != publicFields && publicFields.length > 0){
			tempArray.addAll(Arrays.asList(publicFields));
		}
		Field [] srcFields = tempArray.toArray(new Field[tempArray.size()]);
		return srcFields;
	}	
	
	
	public static Field[] getAllFields(Class sourceClazz) {
		
		if(null == sourceClazz){return null;}
		
		Field[] privateFields= sourceClazz.getDeclaredFields();
		Field[] publicFields= sourceClazz.getFields();
		
		for(Field prvField:privateFields){System.out.println(" prvField : "+prvField.getName());}
		for(Field pubField:publicFields){System.out.println(" publicFields : "+pubField.getName());}
		
		ArrayList<Field> tempArray = new ArrayList<Field>();
		if(null != privateFields && privateFields.length > 0){
			tempArray.addAll(Arrays.asList(privateFields));
		}
		if(null != publicFields && publicFields.length > 0){
			tempArray.addAll(Arrays.asList(publicFields));
		}
		Field [] srcFields = tempArray.toArray(new Field[tempArray.size()]);
		return srcFields;
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

}
