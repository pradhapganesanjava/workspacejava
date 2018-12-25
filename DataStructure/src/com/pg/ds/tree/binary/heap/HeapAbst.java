package com.pg.ds.tree.binary.heap;

public abstract class HeapAbst {

	int[] arr ;
	
	public HeapAbst(int[] arrP) {
		this.arr = arrP;
	}
	
	public int[] heapify(){
		return heapifyUpIter();
		//return heapifyDown(arr,arr.length);
	}

	private int[] heapifyUpIter() {
		if(null == arr) return null;
		for(int i = 1; i < arr.length ; i++){

			int ic = i;
			int ip = getParent(ic);

			int ict = ic;
			int ipt = ip;
			while( ip >=0 && isSwapReq(ict, ipt)){
				swap(ict,ipt);
				ict = ipt;
				ipt = getParent(ict);
			}
		}
		return arr;
	}
	
	public int[] heapifyDown(int[] arr, int end){
		if(end<=1) return arr;
		for(int i=0; i<(end/2)-1; i++){
			heapifyDownRecur(arr, i, end);
		}
		return arr;
	}
	
	public int[] heapifyDownRecur(int[] arr, int i, int end){
			int l = (i*2)+1;
			int r = (i*2)+2;
			
			int s = i;
			if(l <= end && arr[s] > arr[l]) s=l;
			if(r <= end && arr[s] > arr[r]) s=r;
			
			if( s != i){
				swap(arr, i, s);
				return heapifyDownRecur(arr,0,i);
			}
		return arr;
	}

	private void swap(int[] arr, int i, int s) {
		int tval = arr[i];
		arr[i]=arr[s];
		arr[s] = tval;
	}

	public int[] sort(){
		if(this.arr == null) return null;

		for(int i=0; i< arr.length; i++){
			int n = arr.length -1;
			
			swap(i, n);
			
			int ic = n;
			int ip = getParent(ic);
			while(ic >= i && isMinSwapReq(ic, ip)){
				swap(ic, ip);
				ic = ip;
				ip = getParent(ic);
				if(ic==ip) break;
			}
		}
		return this.arr;
	}
	
	private boolean isMinSwapReq(int ic, int ip) {
		return this.arr[ic] <= this.arr[ip];
	}

	private void swap(int ic, int ip) {
		int icVal = this.arr[ic];
		this.arr[ic] = this.arr[ip];
		this.arr[ip] = icVal; 
	}

	public abstract boolean isSwapReq(int ic, int ip);

	private int getParent(int i) {
		return (i-1)/2;
	}
}
