package solstools.math;

/*
	<a href="https://leetcode.com/problems/count-primes/">204. Count Primes</a>
	
	Count the number of prime numbers less than a non-negative number, n.
	
	Example:
	
	Input: 10
	Output: 4
	Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 */
public class Prime_genPrime {

	public static void main(String[] args) {
		Prime_genPrime_Solution sol = new Prime_genPrime_Solution();
		int n = 102;
		int cnt = sol.countPrimes(n);
		System.out.format("\nCount of primes %d less than %d \n", cnt, n);
	}

}

class Prime_genPrime_Solution{
    public int countPrimes(int n) {
        return sieveAlg(n);
        // return bf(n);
    }
    private int sieveAlg(int n){
        if(n < 2) return 0;
        boolean[] noprime = new boolean[n];
        noprime[0] = true;
        noprime[1] = true;
        int cnt = 0;
        for(int i=2; i<=(int)(Math.sqrt(n)); i++){
            if(!noprime[i]){
                for(int j=2; i*j< n; j++){
                    noprime[i*j] = true;
                }
            }
        }
        for(int i=2; i<n; i++){
            if(!noprime[i]){
            		System.out.print(i+", ");
                cnt++;
            }
        }
        return cnt;
    }
    
    private int bf(int n){
        if(n <= 2) return 0;
        int cnt = 0;
        n-=1;
        while ( n > 1 ){
            if(isPrime(n)){
                cnt++;
            }
            n--;
        }
        return cnt;
    }
    
    private boolean isPrime(int n) {
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