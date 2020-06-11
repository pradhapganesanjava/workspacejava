package com.pg.alg.paranthesis;

public class PermutationOfParanthesis {

	public static void main(String[] args) {
		
		StringBuffer strb = new StringBuffer();

		//generateParanBF(strb, 3, 0);
		//generateParanMyBF(strb, 3, 0, 0);
		generateParanMyBF("", 3, 0, 0);
		
	}

	private static void generateParanMyBF(String str, int N, int oi, int ci) {
		
		if(str.length() == N*2) {
			System.out.println(str);
			return;
		}

		if(oi<N) {
			generateParanMyBF(str+"(", N, oi+1, ci);
		}
		if(ci<oi) {
			generateParanMyBF(str+")", N, oi, ci+1);
		}
			System.err.println(str);
	}

	private static void generateParanMyBF(StringBuffer strb, int N, int oi, int ci) {
		
		if(strb.length() == N*2) {
			System.out.println(strb.toString());
			strb.setLength(strb.length() > 0? strb.length()-1:0);
			return;
		}
			
		
		/*for(int i=oi; i<N; i++) {
			strb.append("(");
			generateParanMyBF(strb, N, ++oi, ci);
			//strb.setLength(strb.length()-1);
			for(int j=0; j<i; j++) {
				strb.append(")");
				generateParanMyBF(strb, N, i, j);
				strb.setLength(strb.length()-1);
			}
			strb.setLength(strb.length()-1);
		}*/
		
			if(oi<N) {
			strb.append("(");
			generateParanMyBF(strb, N, oi+1, ci);
			}
			//strb.setLength(strb.length() > 0? strb.length()-1:0);
			
			if(ci<oi) {
				strb.append(")");
				generateParanMyBF(strb, N, oi, ci+1);
			}
			System.err.println(strb.toString());
			//strb.setLength(strb.length()-1);
			//strb.setLength(strb.length() > 0? strb.length()-1:0);
		
		/*for(int i = oi; i<N; i++) {
			strb.append("(");
			generateParanMyBF(strb, N, i, ci);
			strb.setLength(strb.length() > 0? strb.length()-1:0);
		}
		for(int j = ci; j<oi; j++) {
			strb.append(")");
			generateParanMyBF(strb, N, oi, j);
			strb.setLength(strb.length() > 0? strb.length()-1:0);
		}*/
		
		return;
		
	}

	private static void generateParanBF(StringBuffer strb, int N, int cnt) {
		
		if(strb.length() >= N*2 ) {
			System.out.println(strb.toString());
			return;
		}
		strb.append("(");
		generateParanBF(strb, N, cnt+1);
		strb.setLength(strb.length() > 0? strb.length()-1:0);
		strb.append(")");
		generateParanBF(strb, N, cnt+1);
		strb.setLength(strb.length() > 0? strb.length()-1:0);
		
		/*for(int i = oi; i<N; i++) {
			strb.append("(");
			generateParan(strb, N, i, ci);
			strb.setLength(strb.length() > 0? strb.length()-1:0);
		}
		for(int j = ci; j<N; j++) {
			strb.append(")");
			generateParan(strb, N, oi, j);
			strb.setLength(strb.length() > 0? strb.length()-1:0);
		}
		*/
		return;
		
	}

}
