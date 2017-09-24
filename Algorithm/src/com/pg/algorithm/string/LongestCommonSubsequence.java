package com.pg.algorithm.string;

public class LongestCommonSubsequence {
	public static void commonSubsequence(String S1, String S2) {
		int s1_len = S1.length();
		int s2_len = S2.length();
		final int pick_s1_or_s2 = 0;
		final int pick_s1 = 1;
		final int pick_s2 = 2;
		int match[][] = new int[s1_len][s2_len];
		int pointer[][] = new int[s1_len][s2_len];

		for (int i = 0; i < s1_len; i++) {
			for (int j = 0; j < s2_len; j++) {
				if (S1.charAt(i) == S2.charAt(j)) {
					if ((i == 0) || (j == 0)) {
						match[i][j] = 1;
					} else {
						match[i][j] = match[i - 1][j - 1] + 1;
					}
					pointer[i][j] = pick_s1_or_s2;
				} else {
					if ((i > 0) && (j > 0)) {

						if (match[i - 1][j] >= match[i][j - 1]) {
							match[i][j] = match[i - 1][j];
							pointer[i][j] = pick_s2;
						} else {
							match[i][j] = match[i][j - 1];
							pointer[i][j] = pick_s1;
						}
					} else if ((i == 0) && (j > 0)) {
						match[i][j] = match[i][j - 1];
						pointer[i][j] = pick_s1;
					} else if ((j == 0) && (i > 0))

					{
						match[i][j] = match[i - 1][j];
						pointer[i][j] = pick_s2;
					}

				}

			}
		}

		int i = s1_len - 1;
		int j = s2_len - 1;
		StringBuffer result = new StringBuffer();

		while (i >= 0 && j >= 0) {
			switch (pointer[i][j]) {

			case pick_s1_or_s2:
				result.append(S1.charAt(i));
				i--;
				j--;
				break;
			case pick_s1:
				j--;
				break;
			case pick_s2:
				i--;
				break;
			}
		}

		System.out.println(result.reverse());

	}

	public static void main(String args[]) {
		commonSubsequence("cat", "ct");
	}
}