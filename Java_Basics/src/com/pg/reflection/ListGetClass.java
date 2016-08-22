package com.pg.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ListGetClass {

	private List<ADummy> adummyLst;
	private List aDummy2List;
	
	private static Date dob;
	
	public static void main(String... str){
		
		List<String> strLst=null;
		
		
		//new ListGetClass().testListMethod();
		
		/*strLst = getInstance(strLst.getClass());
		if(null != strLst){
			strLst.to
		}*/
		
		//Map<Integer, Object> hMap = new HashMap<Integer, Object>();
		ConcurrentHashMap<Integer, Object> hMap = new ConcurrentHashMap<Integer, Object>();
		 try{
		
			 
			 
			 dob = new SimpleDateFormat("mm/dd/yyyy").parse("06/26/1985");
			System.out.println("hashcode "+dob.toString().hashCode());
			hMap.put(dob.toString().hashCode(), dob);
		}catch(ParseException e){
		}
		
		 System.out.println(" hMap contains "+hMap.containsKey(dob.toString().hashCode()));
		 System.out.println(" hMap value "+hMap.get(dob.toString().hashCode()));
	}
	
	

	private void testListMethod() {

		Method[] outputMethods = ListGetClass.class.getDeclaredMethods();

		for (int count = 0; count < outputMethods.length; count++) {

			Method outputMethod = outputMethods[count];
			String methodName = outputMethod.getName();

			if ("setAdummyLst".equalsIgnoreCase(methodName) || "setaDummy2List".equalsIgnoreCase(methodName)) {

				Class parameterArgClass = getMethodParameterArgType(outputMethod);

				Object obj = null;
				try {
					obj = parameterArgClass.newInstance();

				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
				if(obj != null){
					System.out.println(" obj type "+obj.getClass().getName());
				}
			}
		}
	}


	private Class getMethodParameterArgType(Method outputMethod) {
		Type[] genericParameterTypes = outputMethod
				.getGenericParameterTypes();
		Class parameterArgClass = null;
		for (Type genericParameterType : genericParameterTypes) {
			if (genericParameterType instanceof ParameterizedType) {
				ParameterizedType aType = (ParameterizedType) genericParameterType;
				Type[] parameterArgTypes = aType
						.getActualTypeArguments();
				for (Type parameterArgType : parameterArgTypes) {
					parameterArgClass = (Class) parameterArgType;
					System.out.println("parameterArgClass = "
							+ parameterArgClass);
				}
			} else {
				Type[] outputMthParamTypeArr = outputMethod
						.getParameterTypes();
				for (Type outputMthParamType : outputMthParamTypeArr) {
					parameterArgClass = (Class) outputMthParamType;
				}
			}
		}
		return parameterArgClass;
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




	public List<ADummy> getAdummyLst() {
		return adummyLst;
	}




	public void setAdummyLst(List<ADummy> adummyLst) {
		this.adummyLst = adummyLst;
	}


	public List getaDummy2List() {
		return aDummy2List;
	}


	public void setaDummy2List(List aDummy2List) {
		this.aDummy2List = aDummy2List;
	}

}

class ADummy{
	
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	
	
}
