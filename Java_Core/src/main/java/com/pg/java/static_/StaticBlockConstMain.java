package com.pg.java.static_;

public class StaticBlockConstMain {

	static{
		System.out.println("STATIC BLOCK is called");
	}
	{
		System.out.println("ANNONYMOUS is called");
	}
	
	public StaticBlockConstMain() {
		System.out.println("CONSTRUCTOR is called");
	}
	
	public static void main(String...args) {
		System.out.println("MAIN is called");
		System.out.println("Invoke method " + new StaticBlockConstMain().method1("asdf"));
	}
	public String method1(String str1){
		System.out.println(str1);
		try{
			System.out.println("try");
			return "try";
		}catch(Exception e){
			return "catch";
		}finally{
			System.out.println("finally");
			return "finally";
		}
	}
}
