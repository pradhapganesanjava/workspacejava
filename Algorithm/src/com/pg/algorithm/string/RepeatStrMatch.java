package com.pg.algorithm.string;

import java.math.BigInteger;

public class RepeatStrMatch {

	public static void main(String[] args) {

		System.out.println(" " + findRepeatMatch("abcd", "cdba"));
		System.out.println(" " + findRepeatMatch("abcd", "cdabcdab"));
	}

	private static int findRepeatMatch(String A, String B) {
		int ai = 0;
		int bi = 0;

		StringBuilder sa = new StringBuilder(A);
		int retCount = 1;

		while (ai < sa.length() && bi < B.length()) {
			if (sa.charAt(ai) == B.charAt(bi)) {
				ai++;
				bi++;
				if (ai == sa.length()) {
					sa.append(A);
					retCount++;
				}
				if (bi == B.length() - 1) {
					return retCount;
				}
			} else {
				if (ai + 1 == sa.length()) {
					if (bi == 0) {
						return -1;
					} else if (bi == B.length() - 1) {
						return retCount;
					}
				}
				ai++;
				bi = 0;
				if (ai == sa.length()) {
					sa.append(A);
					retCount++;
				}
			}
		}
		return retCount;
	}

	//Solution# 1
    public int repeatedStringMatch_AdHoc(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++) S.append(A);
        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q+1;
        return -1;
    }	
	
	//Solution# 2
	/**
	 * Complexity Analysis
		Time Complexity: O(M+N)O(M+N) (at these sizes), where M, NM,N are the lengths of strings A, B. 
		As in Approach #1, we justify that A * (q+1) will be of length O(M + N)O(M+N), and computing the rolling hashes was linear work. 
		We will also do a linear O(N)O(N) final check of our answer 1 + O(M) / \mathcal{M}1+O(M)/M times. 
		Space complexity: O(1)O(1). Only integers were stored with additional memory.
	 */

	/*
	 * @param index
	 * @param A
	 * @param B
	 * @return
	 */
    public boolean check(int index, String A, String B) {
        for (int i = 0; i < B.length(); i++) {
            if (A.charAt((i + index) % A.length()) != B.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public int repeatedStringMatch(String A, String B) {
        int q = (B.length() - 1) / A.length() + 1;
        int p = 113, MOD = 1_000_000_007;
        int pInv = BigInteger.valueOf(p).modInverse(BigInteger.valueOf(MOD)).intValue();

        long bHash = 0, power = 1;
        for (int i = 0; i < B.length(); i++) {
            bHash += power * B.codePointAt(i);
            bHash %= MOD;
            power = (power * p) % MOD;
        }

        long aHash = 0; power = 1;
        for (int i = 0; i < B.length(); i++) {
            aHash += power * A.codePointAt(i % A.length());
            aHash %= MOD;
            power = (power * p) % MOD;
        }

        if (aHash == bHash && check(0, A, B)) return q;
        power = (power * pInv) % MOD;

        for (int i = B.length(); i < (q + 1) * A.length(); i++) {
            aHash -= A.codePointAt((i - B.length()) % A.length());
            aHash *= pInv;
            aHash += power * A.codePointAt(i % A.length());
            aHash %= MOD;
            if (aHash == bHash && check(i - B.length() + 1, A, B)) {
                return i < q * A.length() ? q : q + 1;
            }
        }
        return -1;
    }
}

