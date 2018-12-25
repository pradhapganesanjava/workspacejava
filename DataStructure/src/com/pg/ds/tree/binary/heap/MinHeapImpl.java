package com.pg.ds.tree.binary.heap;

public class MinHeapImpl extends HeapAbst {

	public MinHeapImpl(int[] arrP) {
		super(arrP);
	}

	@Override
	public boolean isSwapReq(int ic, int ip) {
		return super.arr[ic] < super.arr[ip];
	}
}
