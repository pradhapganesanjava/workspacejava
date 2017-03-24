package com.pg.dp.factory.dto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;

import com.pg.dp.abstfactory.FactoryHelper;

public abstract class BO {
	
	/*public MO mapToDto(MO doObj){
		
		populateSimpleInstance(this.getClass().getDeclaredMethods())
		return this.mapToDto();
	}*/
	
	public Class<? extends BaseMo> dtoClass;
	
	//public BO INSTANCE = (BO)FactoryHelper.getInstance(BO.class);
	
	/*public void mapToDto(MO doObj, MO dtoObj){
		dtoObj = this.mapToDto(doObj);	
	}*/
	
	/*public MO mapToDto(){
		return this.mapToDto(this);	
	}*/
	
	public BaseMo mapToDto(){
		/*if(null == MO.doObj || null == MO.dtoObj){
			return null;
		}
		Class inputClass = MO.doObj;
		Class outputClass = MO.dtoObj;*/

		Class inputClass;
		Class outputClass;
		
		BaseMo dtoMo = (BaseMo) FactoryHelper.getInstance(dtoClass);
		
		inputClass = this.getClass();
		outputClass = dtoMo.getClass();
		
		
		Method[] inputMethods = inputClass.getDeclaredMethods();
		Method[] outputMethods = outputClass.getMethods();
		try {
			for (int count = 0; count < inputMethods.length; count++) {

				Method methodLo = inputMethods[count];
				String methodName = methodLo.getName();

				Object getMethodObj = null;
				if (null != methodLo
						&& (methodLo.getName().startsWith("get")|| methodLo
								.getName().startsWith("is"))) {
					try {
						getMethodObj = methodLo.invoke(this);
						
						populateOutputObj(dtoMo, outputMethods, methodLo, getMethodObj);

					} catch (IllegalArgumentException e) {
						System.out.println("Exception invoke method "+ methodLo.getName() + " msg:" + e.getMessage());
					} catch (IllegalAccessException e) {
						System.out.println("Exception invoke method "+ methodLo.getName() + " msg:" + e.getMessage());
					} catch (InvocationTargetException e) {
						System.out.println("Exception invoke method "+ methodLo.getName() + " msg:" + e.getMessage());
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//outputClass.
		return dtoMo;
	}	
	
	/*public MO mapToDto(MO doObj, MO dtoObj){
		if(null == MO.doObj || null == MO.dtoObj){
			return null;
		}
		Class inputClass = MO.doObj;
		Class outputClass = MO.dtoObj;

		Class inputClass;
		Class outputClass;
		
		MO dtoMo = (MO) FactoryHelper.getInstance(dtoObj.getClass());
		
		inputClass = doObj.getClass();
		outputClass = dtoMo.getClass();
		
		
		Method[] inputMethods = inputClass.getMethods();
		Method[] outputMethods = outputClass.getMethods();
		try {
			for (int count = 0; count < inputMethods.length; count++) {

				Method methodLo = inputMethods[count];
				String methodName = methodLo.getName();

				Object getMethodObj = null;
				if (null != methodLo
						&& (methodLo.getName().startsWith("get") || methodLo
								.getName().startsWith("is"))) {
					try {
						getMethodObj = methodLo.invoke(this);
						
						populateOutputObj(dtoMo, outputMethods, methodLo, getMethodObj);

					} catch (IllegalArgumentException e) {
						System.out.println("Exception invoke method "+ methodLo.getName() + " msg:" + e.getMessage());
					} catch (IllegalAccessException e) {
						System.out.println("Exception invoke method "+ methodLo.getName() + " msg:" + e.getMessage());
					} catch (InvocationTargetException e) {
						System.out.println("Exception invoke method "+ methodLo.getName() + " msg:" + e.getMessage());
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//outputClass.
		return dtoMo;
	}*/

	private Object populateOutputObj(BaseMo outputObj, Method[] outputMethods, Method methodLo,
			Object getMethodObj) {
		
		Object populateMethodObj = null;
		
		if(null == getMethodObj)return null;
		
		if(isSimpleInstanceof(getMethodObj) ){
			populateMethodObj = populateSimpleInstance(outputObj, outputMethods, methodLo,
					getMethodObj);
		}else if (getMethodObj instanceof BO){
			populateSimpleInstance(outputObj, outputMethods, methodLo,
					((BO)getMethodObj).mapToDto());
			
		}
		return populateMethodObj;
	}

	private Object populateSimpleInstance(BaseMo outputObj, Method[] outputMethods,
			Method methodLo, Object getMethodObj) {

		Object setMethodObj = null;
		
		for (int outCnt = 0; outCnt < outputMethods.length; outCnt++) {

			Method outMethodLo = outputMethods[outCnt];
			
			String inputMthName = stripGetSetfromMethodName(methodLo.getName());
			String outMethodName = stripGetSetfromMethodName(outMethodLo.getName());
			
			if (StringUtils.isNotBlank(inputMthName)&& StringUtils.isNotBlank(outMethodName)
					&& (inputMthName.equalsIgnoreCase(outMethodName)) && outMethodLo.getName().startsWith("set")) {
				try {
					outMethodLo.invoke(outputObj,getMethodObj);
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("Exception invoke method "+ methodLo.getName() + " msg:" + e.getMessage());
				} catch (IllegalAccessException e) {
					System.out.println("Exception invoke method "+ methodLo.getName() + " msg:" + e.getMessage());
				} catch (InvocationTargetException e) {
					System.out.println("Exception invoke method "+ methodLo.getName() + " msg:" + e.getMessage());
				}
			}
		}
		return setMethodObj;
	}

	private String stripGetSetfromMethodName(String methodName) {
		
		String inputMthName = "";
		
		if(StringUtils.isBlank(methodName)){return inputMthName;}
		
		if(methodName.startsWith("get") || methodName.startsWith("set") ){
			inputMthName = methodName.substring(3);
		}else if(methodName.startsWith("is")){
			inputMthName = methodName.substring(2);
		}
		return inputMthName;
	}

	private boolean isSimpleInstanceof(Object getMethodObj) {
		return getMethodObj instanceof String
				|| getMethodObj instanceof java.util.Date
				|| getMethodObj instanceof Integer
				|| getMethodObj instanceof Long
				|| getMethodObj instanceof Float
				|| getMethodObj instanceof Double;
	}
	
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		
		Class className = this.getClass();
		
		strBuilder.append(className.getName()+": ");
		
		Method[] methods = className.getDeclaredMethods();
		for (int index = 0; index < methods.length; index++) {
			Method methodLo = methods[index];
			Object getMethodObj = null;
			if (null != methodLo
					&& (methodLo.getName().startsWith("get") || methodLo
							.getName().startsWith("is"))) {
				try {
					getMethodObj = methodLo.invoke(this);
					if (null != getMethodObj) {
						strBuilder.append(methodLo.getName());
						strBuilder.append(":");
						strBuilder.append(getMethodObj.toString());
						strBuilder.append(", ");
					}
				} catch (IllegalArgumentException e) {
					System.out.println("Exception invoke method "+ methodLo.getName() + " msg:" + e.getMessage());
				} catch (IllegalAccessException e) {
					System.out.println("Exception invoke method "+ methodLo.getName() + " msg:" + e.getMessage());
				} catch (InvocationTargetException e) {
					System.out.println("Exception invoke method "+ methodLo.getName() + " msg:" + e.getMessage());
				}
			}
		}
		return strBuilder.toString();
	}
}
