package com.pg.alg.string.merge;

public class StringBinarySum {

	public static void main(String[] args) {
		StringBinarySum_Solution sol = new StringBinarySum_Solution();
		System.out.println(sol.addBinary("111", "11"));
	}

}

class StringBinarySum_Solution {
    public String addBinary(String a, String b) {
        return sumBinary(a, b);
    }
    
    private String sumBinary(String a, String b){
        
        String s = "";
        int alen = a.length()-1;
        int blen = b.length()-1;
        int c = 0;
        StringBuilder strb = new StringBuilder();
        while(alen >=0 || blen >= 0 || c >0 ){
            int ai = ( alen >=0 ? Integer.valueOf(a.charAt(alen--)) : 0 );
            int bi = (blen >=0 ? Integer.valueOf(b.charAt(blen--)) : 0);
            int ti = ai + bi + c ;
            c = ti/2;
            strb.append(String.valueOf(ti%2));
            //alen--;
            //blen--;
        }
        strb.reverse();
        return strb.toString();
    }
}