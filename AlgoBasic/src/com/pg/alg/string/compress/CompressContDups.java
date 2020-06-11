package com.pg.alg.string.compress;

import java.util.Arrays;

public class CompressContDups {

	public static void main(String[] args) {
		//compressContinuousDups();
		compressWildcardStar();
	}

	private static void compressWildcardStar() {
		String[] sarr = new String[] { 
				"****"
				,"aaa***bbb"
				,"***aaa"
				,"aaa***"
				,"aa**bb**cc"
				,"**aaa**"
				,"*a*b*c*"
		};
		for(String s : sarr) {
			char[] carr = s.toCharArray();
			int l = 0;
			for(int i=0; i<carr.length;) {
				while(i+1<carr.length && carr[i] =='*' && carr[i] == carr[i+1]) {
					i++;
				}
				carr[l++]=carr[i];
				i++;
			}
			System.out.format("IN: %s, Out: %s \n",s, String.valueOf(Arrays.copyOf(carr,l)));
		}
	}

	/****
	 * IN: aaaabbbabab
	 * OUT:ababab
	 */
	private static void compressContinuousDups() {
		
		StringBuilder strb = new StringBuilder("Adsf");
		StringBuilder nstrb = new StringBuilder(strb);
		
		String[] sarr = new String[] { 
				"aaaabbbabab"
				,"ababb"
				,"aaab"
				,"aaaaa"
				,"aabaa"
				,"baaaa"
				,"abbba"
				};
		
		for(String s : sarr) {
			char[] carr = s.toCharArray();
			int l = 0;
			for(int i=0; i<carr.length; ) {
					while(i+1<carr.length && carr[i]==carr[i+1]) {
						i++;
					}
					carr[l++]=carr[i];
					i++;
			}
			System.out.format("IN: %s, Out: %s \n",s, String.valueOf(Arrays.copyOf(carr,l)));
		}
	}

}
