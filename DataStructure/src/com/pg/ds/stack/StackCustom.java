package com.pg.ds.stack;

import java.util.Arrays;

public class StackCustom {
	int SIZE = 5;
	private Object[] data = new Object[SIZE];
	private int counter = 0;

	public synchronized Object push(Object obj) {
		counter++;		
		if (counter > 0 && counter <= data.length) {
			data[counter - 1] = obj;
		}/* else if (counter == 0) {
			data[0] = obj;
		}*/ else {
			data = resizedObjArr();
			data[counter - 1] = obj;
		}
		return obj;
	}

	public synchronized Object pop() {
		Object popObj = null;
		if (counter > 0) {
			popObj = data[counter - 1];
			data[counter - 1] = null;
			counter--;
			return popObj;
		} else {
			throw new RuntimeException("No more data in the Stack");
		}
	}

	public synchronized Object peek() {
		Object popObj = null;
		if (counter > 0) {
			popObj = data[counter - 1];
			return popObj;
		} else {
			throw new RuntimeException("No more data in the Stack");
		}
	}

	private Object[] resizedObjArr() {
		Object[] newData = data;
		System.out.println("Counter " + counter + " data length " + data.length);
		if (counter > data.length) {
			newData = new Object[counter + SIZE];
			int i = 0;
			for (Object objData : data) {
				newData[i] = objData;
				i++;
			}
			System.out.println("dataObj arr resized. Old data "+Arrays.toString(data)+" new data:"+Arrays.toString(newData));
		}
		return newData;
	}

	public static void main(String[] args) {

		String[] str = new String[]{"0","1","2","3","4","5"};
		StackCustom stack = new StackCustom();		
		for(String loStr:str){
			stack.push(loStr);
		}
		
		for(int i=0;i<str.length;i++){
			System.out.println("pop: "+stack.pop());
		}
	}
}
