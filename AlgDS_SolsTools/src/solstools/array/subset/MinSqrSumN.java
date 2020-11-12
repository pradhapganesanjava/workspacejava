package solstools.array.subset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinSqrSumN {

	public static void main(String[] args) {
		
		Set<Integer> st = new HashSet<>();
		Iterator<Integer> iter = st.iterator();
		
		
		MinSqrSumN_Solution sol = new MinSqrSumN_Solution();
		
		sol.numSquares(48);
	}

}
class MinSqrSumN_Solution {
    public int numSquares(int n) {
        return bf(n);
    }
    
    private int bf(int n){
        List<Integer> lst = new ArrayList<>();
        return bf(n, lst);
    }
    
    private Integer bf(int n, List<Integer> lst){
        if(n==0){
        		lst.forEach( ech -> System.out.print(ech+" , "));
        		System.out.println();
            return new Integer(lst.size());
        }

        Integer rint = null;
        int sqrt = (int)Math.sqrt(n);
        for(int i=sqrt; i*i >=1; --i){
            int sqr = i*i;
            if(sqr <= n){
                List<Integer> nlst = new ArrayList<>(lst);
                nlst.add(sqr);
                Integer tint = bf(n-sqr, nlst);
                if(tint != null){
                   rint = rint == null ? tint : Math.min(rint, tint); 
                }
            }
        }
        return rint;
    }
}
class MinSqrSumN_SolutionMem {
	    public int numSquares(int n) {
	        return bf(n);
	    }
	    
	    private int bf(int n){
	        List<Integer> lst = new ArrayList<>();
	        Map<Integer, Integer> mem = new HashMap<>();
	        return bf(n, lst, mem);
	    }
	    
	    private Integer bf(int n, List<Integer> lst, Map<Integer, Integer> mem){
	        if(n==0){
	            return new Integer(lst.size());
	        }
	        if(mem.containsKey(n)){
	            return mem.get(n);
	        }
	        Integer rint = null;
	        int sqrt = (int)Math.sqrt(n);
	        for(int i=sqrt; i*i >=1; --i){
	            int sqr = i*i;
	            if(sqr <= n){
	                List<Integer> nlst = new ArrayList<>(lst);
	                nlst.add(sqr);
	                Integer tint = bf(n-sqr, nlst, mem);
	                if(tint != null){
	                   rint = rint == null ? tint : Math.min(rint, tint); 
	                }
	            }
	        }
	        mem.put(n, rint);
	        return mem.get(n);
	    }
	}