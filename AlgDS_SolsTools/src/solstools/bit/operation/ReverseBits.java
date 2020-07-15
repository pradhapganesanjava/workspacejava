package solstools.bit.operation;

public class ReverseBits {

	public static void main(String[] args) {
		for(int i=1; i<=32; i++){
			int n = 0;
			//n = (1 << (32-i));
			n = (3 >> i-1)&1;
			String s = Integer.toBinaryString(n);
            System.out.println(s.length()+" : "+s);
        }

		int i = 30;
		double d = i/12.0;
		System.err.println((10.4+2)%10);
	}

}
