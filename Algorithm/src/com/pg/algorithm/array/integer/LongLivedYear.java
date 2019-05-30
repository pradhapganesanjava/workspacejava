package com.pg.algorithm.array.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongLivedYear {

	public static void main(String[] args) {

		int[] ibuk = new int[101];
		
		List<Integer[]> loar = new ArrayList<>();
		
		loar.add(new Integer[] {1908,1922});
		loar.add(new Integer[] {1906,1920});
		loar.add(new Integer[] {1910,1919});
		loar.add(new Integer[] {1900,1990});
		loar.add(new Integer[] {1922,1980});
		loar.add(new Integer[] {1920,1935});
		
		loar.forEach( ech -> {
			int idx = ech[0]-1900;
			while(idx<=ech[1]-1900) {
				ibuk[idx] = ibuk[idx]+1;
				idx++;
			}
		});
		
		//Arrays.asList(ibuk).stream().reduce( (id, ac) -> max = Math.max(max, ac));
		int mx = Integer.MIN_VALUE;
		int mxi = -1;
		for(int i=0; i<ibuk.length; i++) {
		 if(ibuk[i] > mx) {
			 mxi = i;
			 mx = ibuk[i];
		 }
		}
		System.out.println(mxi + 1900);
	}

}
