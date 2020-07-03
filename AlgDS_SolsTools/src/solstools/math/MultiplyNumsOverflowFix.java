package solstools.math;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiplyNumsOverflowFix {

	public static void main(String[] args) {

		BigDecimal bd = new BigDecimal(Integer.MAX_VALUE).multiply(new BigDecimal(2));
		System.out.println(bd.intValue());
		
		int db = (int)((Math.sqrt(65) * Math.sqrt(2)));
		System.out.println(db);
		List<Integer> ilst = new LinkedList<>();
		ilst.add(0, 1);
	}

}
