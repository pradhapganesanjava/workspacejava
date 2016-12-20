package com.pg.java8.func;

public class MyFunctionalInterface {

	public static void main(String...str){
		
		MySimpleFunctionalInterf myInterf = () -> {
			System.out.print("safd");
			return "adsf";
		};
	
		
		
		ReqResFuncInterf reqRes = (a) -> {
			return "Hi "+a;
		};
		
		System.out.println(" "+myInterf.isAlphaOnlyStr());
		
		
		
	}
	



}

//If an interface has only one method it can act as Functional Interface; 
interface MySimpleFunctionalInterf{
	String isAlphaOnlyStr();
}

interface NotificationFuncInterf{
	String notifyClient();
}

interface ReqResFuncInterf{
	String acknowlege(String req);
}

interface OnewayFuncInterf{
	//fire and forget
	void increaseCount(int in);
}
