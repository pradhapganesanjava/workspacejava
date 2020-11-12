package solstools.array.modify;

import java.util.Arrays;

public class ArrRotateK {

	public static void main(String[] args) {
		
		StringBuilder strb = new StringBuilder("abcd");

		int[] iarr = {-1,4,5,88,22,3,77,999};
		int k = 0;
		
		k %= iarr.length;
		
		reverse(iarr, 0, iarr.length-1);
		reverse(iarr, 0, k-1);
		reverse(iarr, k, iarr.length-1);
		
		System.out.println(Arrays.toString(iarr));
	}

	private static void reverse(int[] iarr, int s, int e) {
		while(s<e) {
			int t = iarr[s];
			iarr[s++]=iarr[e];
			iarr[e--]=t;
		}
	}

}
