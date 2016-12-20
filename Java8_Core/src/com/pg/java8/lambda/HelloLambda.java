package com.pg.java8.lambda;

import java.util.function.Function;

/*
  * Lambda expression:
  *   > shorthand anonymous implementation for Interface has only one method (FunctionalInterface)
  *   > Lambda expression also can be passed as parameter in place of Functional Interface.
  * Lambda expression contains two parts
  * 	 1) variable that points to implementation ( myVarName = () -> methodCall )
  * 	 2) the implementation uses the variable   ( () -> methodCall )
 	> Internal method knows, what's parameter type (FUNCTIONAL INTERFACE) it takes, so it skips to create instance; 
 	> body of the method by passing parameters; 
 	> totally new to Java - an variable can be declared without mention about its type
 */
public class HelloLambda {

	public static void main(String[] args) {

		AnyInterfCalledFunctionalInterf simpleFunctionalIntf = null;

		// parameter WITHOUT explicit type
		simpleFunctionalIntf = (name) -> ("Hello..." + name + " welcome to lambda world !!!");
		System.out.println(simpleFunctionalIntf.hasOnlyOneMethod("Pradhap"));

		// parameter with type
		simpleFunctionalIntf = (String strName) -> ("Hello..." + strName + " welcome to lambda world !!!");
		System.out.println(simpleFunctionalIntf.hasOnlyOneMethod("PRADHAP"));
		
		// expression can be return within {} braces.
		simpleFunctionalIntf = (String strName) -> {
			return "Hello..." + strName.toLowerCase() + " welcome to lambda world !!!";
		};
		System.out.println(simpleFunctionalIntf.hasOnlyOneMethod("PRADHAP"));

	}

	private static void simpleMethod(Integer i) {
		System.out.println(" " + i);
	}
}

interface AnyInterfCalledFunctionalInterf {
	public String hasOnlyOneMethod(String name);
}
