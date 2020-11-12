package solstools.bit.operation;

public class ComplimentNum {

	public static void main(String[] args) {
		ComplimentNum_Solution sol = new ComplimentNum_Solution();
		sol.bitwiseComplement(5);
	}

}

class ComplimentNum_Solution {
    public int bitwiseComplement(int N) {
        return lfRtShift(N);
    }
    private int lfRtShift(int n){
        int r = 0;
        int p = 0;
        
        while(n>0){
            System.out.println("n: "+n+" bi: "+Integer.toBinaryString(n));
            int t = n>>1;
            System.out.format("n>>1 "+ t +" &: "+ (t&1));
            if ( (t & 1) == 0){
               r |= (1 << p);
              System.out.println(Integer.toBinaryString(r));
            }
            if(r>0){
                p++;
            }
            n = (n>>1);
        }
        return r;
    }
}