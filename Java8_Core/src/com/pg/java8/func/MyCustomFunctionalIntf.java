package com.pg.java8.func;

public class MyCustomFunctionalIntf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

 	private <T,R> R processReqRes(MyFunctionalInterf<? super T,? super R> funcIntf){
 		T t;
 		//return (R)funcIntf.reqRes(t);
 		return null;
 	}
}


interface MyFunctionalInterf<T,R>{
	R reqRes(T str);
}