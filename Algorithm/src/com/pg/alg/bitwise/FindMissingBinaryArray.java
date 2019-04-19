package com.pg.alg.bitwise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FindMissingBinaryArray {

	public static void main(String[] args) {
		
		String[] bitArr = generateBiArr(14);
		System.out.println(Math.sqrt(1));
		
		for(int i = bitArr.length-1; i>=0; i--) {
			
			int tn = i;

			while(tn>0) {
				int tpow = 0;
				int sqrt = (int) Math.sqrt(tn);
				for(int j = 0; j<=  sqrt && Math.pow(2, j) <=tn;j++) {
					tpow = j;
				}
				String rs = new StringBuilder(bitArr[i]).reverse().toString();
				if(rs.charAt(tpow) != '1') {
					System.out.format("missing number is %d , bi : %s ", i, bitArr[i]);
					break;
				}
				tn = tn - (int)Math.pow(2, tpow);
			}
			
		}
	}

	private static String[] generateBiArr(int len) {
		int n = len + 1;
		String[] bitArr = new String[len];
		int ti = 0;
		for(int i=0; i<len; i++, ti++) {
			if(i==n/2) {
				System.out.format("Left out number %d, bi is %s ", ti, Integer.toBinaryString(ti));
				ti+=1;
			}
			bitArr[i] = Integer.toBinaryString(ti);
		}
		
		List<String> strLst = Arrays.asList(bitArr);
		//IntStream.range(0, strLst.size()).forEach( );
		strLst.forEach( ech -> System.out.println(Integer.parseInt(ech,2)+" : "+ ech));
		return bitArr;
	}

}
