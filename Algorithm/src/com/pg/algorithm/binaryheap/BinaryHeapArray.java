package com.pg.algorithm.binaryheap;

import java.util.Arrays;

public class BinaryHeapArray<K extends Comparable<K>> {

	int capacity = 5;
	int size = 0;
	K[] heapArr = null;
	
	public BinaryHeapArray() {
		//heapArr = (K[]) new Object[capacity];
		heapArr = (K[]) new Comparable[capacity];
	}

	public K max() {
		return null;
	}

	public K delMax() {
		return null;
	}

	public boolean isEmpty() {
		return false;
	}

	public void insert(K key) {
		if (size + 1 >= heapArr.length) {
			heapArr = resizeArr();
		}
		heapArr[++size] = key;
		heapUp(size);
	}

	private K[] resizeArr() {
		int currCapacity = heapArr.length;
		return Arrays.copyOf(heapArr, currCapacity * 2);
	}

	public void remove() {

	}

	public void peek() {

	}

	public void heapUp(int k) {
		while (k > 1 && isLess(k / 2, k)) {
			swap(k, k / 2);
			k = k / 2;
		}
	}
	
	public void heapDown(int k) {
		while (k > 1 && isLess(k / 2, k)) {
			swap(k, k / 2);
			k = k / 2;
		}
	}

	private void swap(int fromK, int toK) {
		K tmp = heapArr[fromK];
		heapArr[fromK] = heapArr[toK];
		heapArr[toK] = tmp;
	}

	private boolean isLess(int parent, int child) {
		if(parent ==0 || child==0){
			return false;
		}
		if (heapArr[parent].compareTo(heapArr[child]) < 0) {
			return true;
		} else {
			return false;
		}
	}

	private void print() {
		for (int i = 0; i < size+1; i++) {
			System.out.println(" " + heapArr[i]);
		}
	}

	public static void main(String... str) {
		int[] inpArr = new int[] { 5, 3, 1, 9, 2 };
		BinaryHeapArray<Integer> biHeap = new BinaryHeapArray<Integer>();
		for (int i : inpArr) {
			biHeap.insert(i);
		}
		biHeap.print();
	}
}
