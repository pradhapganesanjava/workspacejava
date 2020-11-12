package algds.array.subset.cont;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String[][] sarr = { {"aaaaa","aaabbaaaa"}
						  ,{"abaabbbaba","baabaabb"}};
		
		for(String[] s2 : sarr) {
			String lcs = bf_n3(s2[0],s2[1]);
			System.out.format("s1: %s, s2: %s lcs: %s \n",s2[0],s2[1],lcs);
		}
	}
	/*

     a bcd
     ab bcd
	 
	 */

	private static String bf_n3(String s1, String s2) {
		int mxl = 0;
		String lcs = null;
		for(int i=0; i<s1.length(); i++) {
			for(int j=0; j<s2.length(); j++) {
				int ti = i;
				int tj = j;
				while(ti < s1.length() && tj < s2.length() && s1.charAt(ti)==s2.charAt(tj)) {
					ti++;
					tj++;
				}
				if(ti>i && mxl < (ti-i)) {
					lcs = s1.substring(i,ti);
					mxl = (ti-i);
				}
			}
		}
		return lcs;
	}

}
