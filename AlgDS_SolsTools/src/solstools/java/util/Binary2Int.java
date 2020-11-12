package solstools.java.util;

public class Binary2Int {

	public static void main(String[] args) {
		binaryStr2Integer();
	}

	private static void binaryStr2Integer() {
		String s = "10000";
		// parser(s);
		bitwise(s);
	}

	private static void parser(String s) {
		Integer iv = Integer.parseInt(s, 2);
		System.out.format("Bi: %s => int: %d \n", s, iv);
	}
	
	private static void bitwise(String s) {
		LeftShiftOR(s);
		//streamBit2Int(s);
	}
	/*
	  s = 100; num = 0;
	      =>  0 << 1 =>   0  | 1 => 1
	  	  =>  1 << 1 =>  10  | 0 => 10
	  	  => 10 << 1 => 100  | 0 => 100
      
	 */
	private static void LeftShiftOR(String s) {
		int num = 0;
		for(char ch : s.toCharArray()) {
			num = (num << 1) | (int)(ch-'0');
		}
		System.out.format("Bi: %s => int: %d \n", s, num);
	}
	
	private static void streamBit2Int(String s) {
		int num = 0;
		for(char ch : s.toCharArray()) {
			num = streamBit2Int( num << 1, (int)(ch-'0'));
		}
		System.out.format("Bi: %s => int: %d \n", s, num);
	}
	
	private static int streamBit2Int(int num, int bit) {
		return num | bit;
	}
}
