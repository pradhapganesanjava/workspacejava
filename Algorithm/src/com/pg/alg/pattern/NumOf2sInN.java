package com.pg.alg.pattern;

public class NumOf2sInN {

	public static void main(String[] args) {

		int N = 3;
		System.out.format("N: %d, countOf2s: %d \n", N, countAll2s(N));

		N = 0;
		System.out.format("N: %d, countOf2s: %d \n", N, countAll2s(N));

		N = 1;
		System.out.format("N: %d, countOf2s: %d \n", N, countAll2s(N));

		N = 2;
		System.out.format("N: %d, countOf2s: %d \n", N, countAll2s(N));

		N = 13;
		System.out.format("N: %d, countOf2s: %d \n", N, countAll2s(N));

		N = 11;
		System.out.format("N: %d, countOf2s: %d \n", N, countAll2s(N));

		N = 23;
		System.out.format("N: %d, countOf2s: %d \n", N, countAll2s(N));

		N = 123;
		System.out.format("N: %d, countOf2s: %d \n", N, countAll2s(N));

		N = 234;
		System.out.format("N: %d, countOf2s: %d \n", N, countAll2s(N));

		N = 644;
		System.out.format("N: %d, countOf2s: %d \n", N, countAll2s(N));

	}

	private static int countAll2s(int N) {
		int cnt = 0;
		/*int k = 10;
		while (N > 0) {
			int tN = N % k;
			cnt += get2sCnt(tN);
			N = N - (N % k);
			k = k * 10;
		}*/
		
		for (int i = N; i >0; i--) {
			cnt += get2sCnt(i);
		}

		return cnt;
	}

	private static int get2sCnt(int num) {
		int cnt = 0;
			while (num > 0) {
				if (num % 10 == 2) {
					cnt += 1;
				}
				num = num /10;
			}
		return cnt;
	}

}
