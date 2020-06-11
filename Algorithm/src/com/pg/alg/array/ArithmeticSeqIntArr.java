package com.pg.alg.array;

/**
 * 
 Check if an integer array is arithmetic sequence. Array may not be sorted
 * Example: 1, 2, 3, 4, 5, 6, 7, 8 => true (OR) 8,1,3,2,5,4,7,6 => true 1, 3, 5,
 * 7, 9 => true (OR) 3, 9, 1, 5, 7 => true
 * 
 * clue: (max - min)/(len - 1) = difference
 * 
 * @author pganesan
 * 
 */
public class ArithmeticSeqIntArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] intArr = new int[] { 8, 1, 3, 2, 18, 5, 4, 7, 6 };
		System.out.println(isArithmeticSeqUnsortedArray(intArr));

	}

	private static boolean isArithmeticSeqUnsortedArray(int[] intArr) {
		int size = intArr.length;
		int minInt = 0;
		int maxInt = 0;
		int midInt = 0;
		// size & 1 ==> size % 2 ( 2 => (1<<1)-1)
		if ((size & 1) != 0) {
			midInt = intArr[(size >> 1)];
		}
		for (int i = 0; i < size >> 1; i++) {
			if (i == 0) {
				if (intArr[i] < intArr[size - 1 - i]) {
					minInt = intArr[i];
					maxInt = intArr[size - 1 - i];
				} else {
					maxInt = intArr[i];
					minInt = intArr[size - 1 - i];
				}
				continue;
			}
			if (intArr[i] < minInt) {
				minInt = intArr[i];
			}
			if (intArr[size - 1 - i] < minInt) {
				minInt = intArr[size - 1 - i];
			}

			if (intArr[i] > maxInt) {
				maxInt = intArr[i];
			}
			if (intArr[size - 1 - i] > maxInt) {
				maxInt = intArr[size - 1 - i];
			}
		}
		if (midInt != 0) {
			if (midInt < minInt) {
				minInt = midInt;
			}
			if (midInt > maxInt) {
				maxInt = midInt;
			}
		}

		int difference = (maxInt - minInt) / (size - 1);

		for (int i = 0; i < size >> 1; i++) {
			if (!(intArr[i] % difference == 0 || intArr[size - 1 - i] % difference == 0)) {
				return false;
			}
		}
		return true;
	}

}
