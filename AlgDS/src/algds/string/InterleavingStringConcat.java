package algds.string;

public class InterleavingStringConcat {

	public static void main(String[] args) {
		InterleavingStringConcat_Solution sol = new InterleavingStringConcat_Solution();
		// boolean flg = sol.isInterleave("aabcc","dbbca","aadbbbaccc");
		 boolean flg = sol.isInterleave("aabcc","dbbca","aadbbcbcac");
		
		System.out.println(flg);
	}

}

class InterleavingStringConcat_Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return mem(s1, s2, s3);
       //  return bfRecur(s1, s2, s3);    
    }
    private boolean mem(String a, String b, String c){
        if(c.length() != a.length()+b.length()) return false;
        return mem(a, b, c, 0, 0, 0);
    }
    private boolean mem(String a, String b, String c, int ai, int bi, int ci){
        if(ci == c.length()){
            return ai==a.length() && bi==b.length();
        }
        if(ai==a.length()){
            return c.substring(ci, c.length()).equals(b.substring(bi, b.length()));
        }
        if(bi==b.length()){
            return c.substring(ci, c.length()).equals(a.substring(ai, a.length()));
        }        
        if(c.charAt(ci)==a.charAt(ai) 
             || c.charAt(ci)==b.charAt(bi)){
            return  (mem(a, b, c, ai+1, bi, ci+1) || mem(a, b, c, ai, bi+1, ci+1));      
        }
        return false;
    }
}