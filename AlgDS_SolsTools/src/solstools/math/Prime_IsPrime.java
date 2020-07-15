package solstools.math;

public class Prime_IsPrime {

	public static void main(String[] args) {
		
		System.out.println(21%3);
		
		Prime_IsPrime_Solution sol = new Prime_IsPrime_Solution();
		for(int i=2; i< 100; i++){
			boolean flg =  sol.isPrime(i);
			if(flg) {
				System.err.format("%d : isPrime? %b \n",i, flg);
			}else {
				System.out.format("%d : isPrime? %b \n",i, flg);
			}
		}


	}

}
class Prime_IsPrime_Solution{
	public boolean isPrime(int n) {
		int t = (int) (Math.sqrt(n));
		while(t>1){
			if(n%t == 0){
				return false;
			}
			t--;
		}
		return true;
	}
}
