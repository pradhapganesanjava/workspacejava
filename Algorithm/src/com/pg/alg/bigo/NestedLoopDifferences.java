package com.pg.alg.bigo;

public class NestedLoopDifferences {
	static int gcnt = 0;
	public static void main(String...s){
		
		int n = 10;
		int count = 0;
		int out=0;
		int in=0;
		for(int i=0; i<n; i++){
			// count++;
			// out++;
			for(int j=0; j<i; j++){
				count++;
				//in++;
			}
			System.out.format("(1) INCR count: %d \n", count );
		}
		//System.out.format("n : %d, count: %d, out: %d, in: %d \n", n, count, out, in);
		System.out.format("count: %d \n", count );
		
		
		n = 10;
		count = 0;
		out=0;
		in=0;
		for(int i=0; i<n; i++){
			 count++;
			// out++;
			for(int j=0; j<n; j++){
				count++;
				// in++;
			}
			System.out.format("(n^2) INCR count: %d \n", count );
		}
		// System.out.format("(n^2) n : %d, count: %d, out: %d, in: %d \n", n, count, out, in);
		System.out.format("(n^2) count: %d \n", count);

		n = 10;
		count = 0;
		out=0;
		in=0;
		for(int i=0; i<n; i++){
			// count++;
			// out++;
			for(int j=i; j<n; j++){
				count++;
				// in++;
			}
			
		}
		// System.out.format("(~n^2) n : %d, count: %d, out: %d, in: %d", n, count, out, in);
		System.out.format("(~n^2) count: %d \n", count );

		n = 10;
		for(int i=1; i<=n; i++){
			//gcnt++;
			//fib(i);
			System.out.println(fib(i));
			System.out.format("fib i: %d count: %d \n", i,  gcnt );
		}
		System.out.format("fib count: %d \n", gcnt );
		
		gcnt = 0;
		System.out.format("indep fib %d, gcnt %d \n", fib(10), gcnt);
				
		/*n = 1000;
		count = 0;
		for(int i=0; i<n; i++){
			int j = i;
			int sum = 0;
			while(j>=0){
				if(j==0) sum += 0;
				if(j==1) sum += 1;
				if(j==2) sum += 1;
				
				int k = j;
				j -= 1;
				continue;
			}
		}*/
		
		n = 10;
		int s1=0;
		int s2=0;
		
		for(int i = 0; i < n; i++){
			if(i==0){
				s1=0;
				s2=1;
			}else if ( i==1){
				s1=0;
				s2=1;
			}else{
				int st = s1 + s2;
				s1 = s2;
				s2 = st;
			}
			System.out.println(s1+s2);
		}
		//System.out.format("for-while %d ", count);
		
	}

	private static int fib(int i) {
		gcnt=gcnt+1;
		if(i<=0) return 0;
		if(i==1) return 1;
		if(i==2) return 1;
		return fib(i-1)+fib(i-2);
	}
}
