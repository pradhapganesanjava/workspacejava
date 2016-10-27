package com.pg.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AbstBo {

	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		Class className = this.getClass();
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
					System.out.println("Exception invoke method "
							+ methodLo.getName() + " msg:" + e.getMessage());
				} catch (IllegalAccessException e) {
					System.out.println("Exception invoke method "
							+ methodLo.getName() + " msg:" + e.getMessage());
				} catch (InvocationTargetException e) {
					System.out.println("Exception invoke method "
							+ methodLo.getName() + " msg:" + e.getMessage());
				}
			}
		}
		return strBuilder.toString();
	}

}
