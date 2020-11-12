package solstools.java.util;

import java.util.TreeSet;

public class TreeSet_Highend {

	public static void main(String[] args) {
		TreeSet<Integer> tset = new TreeSet<>();
		tset.add(-10);
		tset.add(0);
		tset.add(-90);
		tset.add(1);
		tset.add(100);
		tset.add(-1);
		tset.add(1000);
		
		int[] nums = {-9, -10, 0, -99,-91, -90, -89, -2,-1,2,10,99,101,1001};
		
		for(int num : nums) {
			
			System.out.format("num: %d, high: %d \n",num, tset.higher(num));
			
		}
	}

}
