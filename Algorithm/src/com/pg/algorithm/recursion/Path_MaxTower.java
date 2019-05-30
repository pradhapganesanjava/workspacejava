package com.pg.algorithm.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Path_MaxTower {
	
	static Map<String, Integer> memoiz = new HashMap<>();

	public static void main(String[] args) {
		int[][] persArr = new int[][] {
			{75,190},
			{70,200},
			{68,195},
			{65,110},
			{60,100},
			{56,95}
		};
		
		
		
		List<Person> persLst = new ArrayList<>();
		
		for(int i=0; i<persArr.length; i++) {
			Person nwPers =  new Person(persArr[i][0],persArr[i][1]) ;
				persLst.add(nwPers);
				memoiz.put(nwPers.toString(), -1);
		}

        persLst.sort(Path_MaxTower::sortPersonByHeight);
        int maxHt = Integer.MIN_VALUE;
        int i = 0;
        for(Person pers : persLst){
        	List<Person> mxPath = new ArrayList<>();
        		mxPath.add(pers);
          int nwHt = findMxPathRecur(pers, persLst, mxPath, i+1);
          i+=1;
          if(Math.max(maxHt, nwHt) != maxHt) {
        	  	mxPath.forEach(ech -> System.out.print(ech + " -> "));
        	  	System.out.println();
          }
          maxHt = Math.max(maxHt, nwHt);
        }
        
        System.out.println("mx : " + maxHt);
	}

    private static int findMxPathRecur(Person pers, List<Person> persLst, List<Person> mxPath, int idx){
        if(idx >= persLst.size()){ return 0;}

        int mx = 0;
        if(memoiz.get(pers.toString()) != -1) {
    			mx += memoiz.get(pers.toString());
        }else {
	        Person curPers = persLst.get(idx);
	        if(isTopable(pers, curPers)){
	        	   mxPath.add(curPers);
	           mx =findMxPathRecur(curPers, persLst, mxPath, idx + 1)  + 1;
	        }else{
	        	   mx =findMxPathRecur(pers, persLst, mxPath, idx + 1);
	        }
	        memoiz.put(pers.toString(),mx);
        }
       return mx;
    }

    private static boolean isTopable(Person pers, Person curPers){
        if(pers == null || curPers == null) return false;
        return pers.ht > curPers.ht && pers.wt > curPers.wt;
    }

    private static int sortPersonByHeight(Person p1, Person p2){
        return  p1.ht > p2.ht ? -1 :
                                p1.ht < p2.ht ? 1 : 0;
    }

}

class Person{
	public int ht;
	public int wt;
	public Person(int ht, int wt) {
		this.ht = ht;
		this.wt = wt;
	}
	@Override
	public String toString() {
		return this.ht +", "+this.wt;
	}
}
