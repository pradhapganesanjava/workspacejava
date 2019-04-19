package com.pg.alg.string;

public class KnuthMorrisPratt_KMP_PatternMatch {

public void patternSearch(String pattern, String text, int[] lps) {
	int pat_index = 0, text_index = 0;

	if (pattern.length() == 0) { return;}

	while (text_index < text.length()) {
		// if characters match, look for next character match
		if (pattern.charAt(pat_index) == text.charAt(text_index)) {
			pat_index++;
			text_index++;

			// indicates that complete pattern has matched
			if (pat_index == pattern.length()) {
				System.out.println("Match");
				pat_index = lps[pat_index - 1];
			}
		}

		// char do not match, adjust the pattern_index
		else {
			if (pat_index != 0) {
				pat_index = lps[pat_index - 1];
			} else {
				text_index++;
			} } } }

void computeLPSArray(String pat, int[] lps) {
	int j = 0; // length of the previous longest prefix suffix
	int i;
	lps[0] = 0; // lps[0] is always 0
	i = 1;

	// the loop calculates lps[i] for i = 1 to M-1
	while (i < pat.length()) {
		if (pat.charAt(j) == pat.charAt(i)) {
			lps[i] = j + 1;
			i += 1;
			j += 1;
		} else 	{ // (pat[i] != pat[j])
			if (j != 0) {
				j = lps[j - 1];
			} else { // if (j == 0)
				lps[i] = 0;
				i++;
			} } } }


	public static void main(String[] args) {
		KnuthMorrisPratt_KMP_PatternMatch solution = new KnuthMorrisPratt_KMP_PatternMatch();

		String pattern = "ananab#banana";
		int[] lps = new int[pattern.length()];
		solution.computeLPSArray(pattern, lps);

		for (int i = 0; i < lps.length; i++) {
			System.out.println(lps[i]);
		}

		String text = "ananab#banancananab#banana";

		solution.patternSearch(pattern, text, lps);
	}

}
