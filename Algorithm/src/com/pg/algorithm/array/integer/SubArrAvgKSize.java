package com.pg.algorithm.array.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrAvgKSize {
	
	static int OofN = 0;

	public static void main(String[] args) {

		int[] iArr = new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2};
		// subarrayNonSequential(iArr, 4);
		subarraySequential(iArr, 5);
		subarraySequentialBF(iArr, 5);
		
	}

	private static void subarraySequentialBF(int[] iArr, int k) {
		int sum = 0;
		for(int i=0; i<iArr.length; i++) {
			for(int j=0; j<k;j++) {
			sum += iArr[i];
			}
		}
			
	}

	private static void subarraySequential(int[] iArr, int k) {
		if(iArr == null || iArr.length < k) return;
		int len = iArr.length;
		double[] res = new double[len-k+1];
		double sum = 0;
		for(int i=0; i<k;i++) {
			sum +=iArr[i];
		}

		res[0] = (double)(sum/k);
		
		for(int i=1; i<len-k+1; i++) {
			sum = (double)(sum + iArr[i] - iArr[i-1]);
			res[i] = (double) (sum/k);
		}
		System.out.println( Arrays.toString(res) );
	}

	private static void subarrayNonSequential(int[] iArr, int k) {
		int len = iArr.length;
		List<List<Integer>> lolst = new ArrayList<>();
		for(int i=0; i<len; i++) {
			OofN++;
			List<Integer> bufLst = new ArrayList<>();
			bufLst.add(iArr[i]);
			
			findAvgRecur(iArr, i, k, bufLst, lolst);

		}
		 lolst.forEach( ech ->{
			 ech.forEach( inech -> System.out.print(inech));
			 System.out.println();
		 });
		 System.out.println("total number of time runs "+OofN);
	}

	private static void findAvgRecur(int[] iArr, int idx, int k, List<Integer> bufLst, List<List<Integer>> lolst) {

		if(null !=bufLst && bufLst.size() == 6) {
			List<Integer> nBufLst = new ArrayList<>();
			bufLst.forEach( ech -> {
				nBufLst.add(ech);
				//OofN++;
			});;
			lolst.add(nBufLst);
			return;
		}
		for(int i=0; i<iArr.length;i++) {
			OofN++;
			if(bufLst.contains(iArr[i])) continue;
			
			bufLst.add(iArr[i]);
			findAvgRecur(iArr, i+1, k, bufLst, lolst);
			if(bufLst.size()>0) {
				bufLst.remove(bufLst.size()-1);
			}
		}
	}

}
