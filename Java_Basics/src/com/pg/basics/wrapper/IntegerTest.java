package com.pg.basics.wrapper;

public class IntegerTest {

	public static void main(String[] args) {
		
		Integer intg = new Integer(100);
		
		if(null != intg && intg>1){
			System.out.println(intg+ " Ingeger is > 1");
		}else{
			System.out.println(intg+ " Ingeger is NOT > 1");
		}
		
		if(null != intg && intg>100){
			System.out.println(intg+ " Ingeger is > 100");
		}else{
			System.out.println(intg+ " Ingeger is NOT > 100");
		}
		

	}

}
