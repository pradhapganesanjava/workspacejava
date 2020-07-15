package solstools.bit.operation;

public class LeastSignificant {

	public static void main(String[] args) {
		int num = 5;
		System.out.println(Integer.toBinaryString(num));
		
		for(int i=0; i<4; i++) {
			System.out.format("i: %d, rightMostDigit: %d \n", i, ((num>>0)&1));
			num = num>>1;
		}

	}

}
