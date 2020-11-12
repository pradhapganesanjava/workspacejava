package algds.array.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PascalTriangle {

	public static void main(String[] args) {
		pascalTriangle(10);
	}

	private static void pascalTriangle(int n) {
		printPascalTriangle(n, new int[] {1});
	}

	private static void printPascalTriangle(int n, int[] iarr) {
		
		System.out.println(Arrays.toString(iarr));
		if(n==0) {
			return;
		}
		int[] narr = new int[iarr.length+1];
		narr[0]=1;
		narr[narr.length-1]=1;
		for(int i=iarr.length-2, j=narr.length-2; i>=0; --i) {
			narr[j--] = iarr[i]+iarr[i+1];
		}
		printPascalTriangle(--n, narr);
	}

}
