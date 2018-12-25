package com.pg.ds.tree.binary.heap;

import java.util.Arrays;
import java.util.List;

public class HeapMain {

	public static void main(String[] args) {
		int[] arr1 = {8,5,1,4,7,9,2};
		int[] arr2 = {1,0,2,-1};
		int[] arr3 = {0,-1};
		int[] arr4 = {11};
		int[] arr5 = {3,2,1,1,2,3};
		
		/*System.out.format("In: %s \n Out: %s \n\n", Arrays.toString(arr1), Arrays.toString(Heapify.array(arr1)));
		System.out.format("In: %s \n Out: %s \n\n", Arrays.toString(arr2), Arrays.toString(Heapify.array(arr2)));
		System.out.format("In: %s \n Out: %s \n\n", Arrays.toString(arr3), Arrays.toString(Heapify.array(arr3)));
		System.out.format("In: %s \n Out: %s \n\n", Arrays.toString(arr4), Arrays.toString(Heapify.array(arr4)));
		System.out.format("In: %s \n Out: %s \n\n", Arrays.toString(arr5), Arrays.toString(Heapify.array(arr5)));*/
		
		List<int[]> arrLst = Arrays.asList(arr1, arr2, arr3, arr4, arr5);
		//List<int[]> arrLst = Arrays.asList(arr2);
		List<int[]> arrLst2 = Arrays.asList(arr5);
		
		arrLst.forEach( arr -> {
			int[] arrOrg = arr.clone();
			Heapify.doHeapify(arr, arr.length);
			//arr = Heapify.down(arr);
			/*MinHeapImpl mh = new MinHeapImpl(arr);
			mh.heapify();*/
			//mh.sort();
			print(arrOrg, arr);
		});

		/*arrLst2.forEach( arr -> {
			MaxHeapImpl mh = new MaxHeapImpl(arr);
			mh.sort();
			print(arr, mh);
		});*/

	}

	private static void print(int[] arr,int[] arr2) {
		System.out.format("In: %s \n Out: %s \n\n", Arrays.toString(arr), Arrays.toString(arr2));
	}
	
}
