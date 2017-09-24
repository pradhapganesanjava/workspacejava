package com.pg.algorithm.sort.insertion;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionSort {

	private static Object[][] arrIntInputs = {
//			{ 10, 5,11, 2, 1, 9 },
//			{},
//			{ 0},
//			{ 0,1},
//			{ 9,8},
//			{ 0,1,2,3,4,5,6,7,8,9},
			{ 9,8,7,6,5},
			{ 9,8,7,6,5,4},			
			{ 9,8,7,6,5,4,3,2,1,0},
//			{ 0,1,2,3,4,8,9,7,6,1,2},
			{ 0,1,2,3,4,5,6,7,8,9,-1},
	};

	private static Comparator<Object> compareIntf = (Object o1, Object o2) -> {
		if (o1 instanceof Integer && o2 instanceof Integer) {
			return ((Integer) o1).compareTo((Integer) o2);
		}else if (o1 instanceof String && o2 instanceof String) {
			return ((String) o1).compareTo((String) o2);
		}
		return 0;
	};
	
	public static void main(String[] args) {
		for(Object[] arrInt : arrIntInputs){
			insertionSort_while(arrInt);
		}
		
	}

	public static void insertionSort_while(Object[] intArr) {
		printLineStars();
		Object[] copyArr = Arrays.copyOf(intArr, intArr.length);
		int count = 0;
		for(int i=0;i<intArr.length;i++){
			int j = i;
			boolean whileFlag = false;
			while(j > 0 && isLesser(intArr[j],intArr[j-1])){
				count++;
				swap(intArr, j,j-1);
				j--;
				if(!whileFlag){
					whileFlag = true;
				}
			}
			if(!whileFlag){
				count++;
			}
			System.out.println(i+": "+Arrays.toString(intArr));
		}
		System.out.println("Input: "+Arrays.toString(copyArr));
		System.out.println("Output: "+Arrays.toString(intArr));
		System.out.println("timeComplex n= "+intArr.length + " \n O( (n^2)/2 - n/2 ) = O( "+count+" )");
		printLineStars();
	}	
	
	
	public static void insertionSort_forloop(Object[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0 && isLesser(arr[j], arr[j - 1]); j--) {
				swap(arr,j,j-1);
			}
		}
	}

	private static boolean isLesser(Object curr, Object prev) {
		return compareIntf.compare(curr, prev) < 0;
	}
	
	private static void swap(Object[] arr,int from, int to){
		Object tmp = arr[from];
		arr[from] = arr[to];
		arr[to]=tmp;
	}
	private static void printLineStars() {
		Character[] arrChar = new Character[80];
		Arrays.asList(arrChar).forEach(i->System.out.print("*"));
		System.out.print("\n");
		//Arrays.asList(arrChar).stream().skip(1).map(i->"*").forEach(System.out::print);
	}

}
