package com.pg.java.array;

public class ArrayInJava {

	public static void main(String[] args) {

		objectArray();
		
		primitiveArray();
		
		for(int i=1;i<10;i++){
			System.out.println(i); }
		
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		if ( a > b ){
		    a = b;
		    b = c;
		}
		
		
	}

	private static void objectArray(){
		Object[] objArr = new Object[] { "String", new Float(3.3), new Integer(10), new Character('c') };
		for(Object obj:objArr){
			
//			System.out.println(" "+ objArr.getClass().getName());
			
	
			
			if(obj instanceof String){
				System.out.println(" String Obj "+obj.toString() );
			}else if(obj instanceof Integer){
				System.out.println(" Integer obj "+ ((Integer)obj).intValue());
			}else if(obj instanceof Float){
				System.out.println(" Float obj "+ ((Float)obj).floatValue());
			}
			
			/*String objClass = obj.getClass().toString();
			
			switch(objClass){
			case "String":
				System.out.println();
			}*/
			
		}
	}
	
	/*
	 * primitive array compile time errors when other types in the array
	 */
	private static void primitiveArray() {
		int[] intArr = new int[]{'A','a','1','2',2};
		
		for(int i=0;i < intArr.length;i ++){
			System.out.println(i +" : " + intArr[i]);
		}
	}

	
	
}
