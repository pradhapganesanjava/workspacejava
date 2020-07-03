package algds.random;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomOnSize {

	public static void main(String[] args) {
		List<Integer> ilst = Arrays.asList(1,2,3,4,5);
		
		int sz = ilst.size();
		
		for(int i=0; i<sz; i++) {
			System.out.println(Math.random()*sz);
		}
		
		Random rand = new Random(sz);
		for(int i=0; i<sz; i++) {
			System.err.println();
		}
	}

}
