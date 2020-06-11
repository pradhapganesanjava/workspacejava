package random.distribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EquallyDistributeN {

	public static void main(String[] args) {
		int N = 10; 
		
		
		Random rand = new Random();
		List<Integer> rlst1 = new ArrayList<>();
		while(rlst1.size()<N) {
			for(int i=N; i>0; --i) {
				//int nxtInt=rand.nextInt(i);
				while(rand.nextInt(i)==0) {
					//System.out.println(i);
					rlst1.add(i);
					break;
				}
				// rlst1.add(nxtInt);
			}
		}
		rlst1.forEach(ech -> System.out.print(ech+", "));
		System.out.println();
		//shallowRandSwapReservoir(N);
		
	}

	private static void shallowRandSwapReservoir(int N) {
		Random rand;
		rand = new Random();
		List<Integer> rlst2 = new ArrayList<>(N+1);
		for(int i=1;i<=N;i++) {
			rlst2.add(i);
		}
		for(int i=N/2; i<=N; i++) {
			int nxtInt=rand.nextInt(i);
			if(nxtInt < N/2) {
				int old = rlst2.get(nxtInt);
				rlst2.set(i, old);
				rlst2.set(old, i);
			}
		}
		rlst2.forEach(ech -> System.out.print(ech+", "));
	}

}
