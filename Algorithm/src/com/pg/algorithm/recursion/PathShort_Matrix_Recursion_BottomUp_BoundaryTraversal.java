package com.pg.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class PathShort_Matrix_Recursion_BottomUp_BoundaryTraversal {

	public static void main(String[] args) {

		int[][] iarr = new int[][] {
			{0, 0, 1, 1, 0},
			{1, 1, 1, 0, 0},
			{1, 0, 0, 1, 1},
			{1, 1, 0, 1, 1},
			{0, 1, 1, 1, 1}
		};
		
		int r = iarr.length-1;
        int c = iarr[0].length-1;

		List<Axis> axLst = findShortestPathRecur(iarr, r, c, 0, 3, new ArrayList<Axis>());
		if(null != axLst) {
			axLst.forEach(ech -> System.out.print(ech + " -> "));
		}
		
	}
	
    private static List<Axis> findShortestPathRecur(int[][] iarr, int r, int c, int rdst, int cdst, List<Axis> axLst){
        if(r == rdst && c == cdst){
            axLst.add(new Axis(r,c));
            return axLst;
        }
        if(!isValidAxis(r,c, iarr)){
            return null;
        }
        
        axLst.add(new Axis(r, c));

        List<Axis> nb1 = findShortestPathRecur(iarr, r, c-1, rdst, cdst, new ArrayList<Axis>());
        List<Axis> nb2 = findShortestPathRecur(iarr, r-1, c, rdst, cdst, new ArrayList<Axis>());
        List<Axis> nb3 = findShortestPathRecur(iarr, r, c+1, rdst, cdst, new ArrayList<Axis>());
        
/*        if(isValidAxis(r-1, c, iarr)){
            List<Axis> t1 = findShortestPathRecur(iarr, r-1, c, rdst, cdst, new ArrayList<Axis>());
            if(t1 != null){
                nb1 = new ArrayList<>();
                nb1.add(new Axis(r,c));
                for(Axis newAx : t1){
                    nb1.add(newAx);
                }
            }
        }
        if(isValidAxis(r, c-1, iarr)){
            List<Axis> t1 = findShortestPathRecur(iarr, r, c-1, rdst, cdst, new ArrayList<Axis>());
            if(t1 != null){
                nb2 = new ArrayList<>();
                nb2.add(new Axis(r,c));
                for(Axis newAx : t1){
                    nb2.add(newAx);
                }
            }           
        }*/
        
        if(nb1 == null && nb2 == null) return null;

        if(nb1 != null && nb2 != null){
            if(nb1.size() >= nb2.size()){
                return nb1;
            }else{
                return nb2;
            }
        }

        if(nb1 != null) return nb1;
        if(nb2 != null) return nb2;

        return axLst;

    }

    private static boolean isValidAxis(int r, int c, int[][] iarr){
        int rx = iarr.length;
        int cx = iarr[0].length;
        return ! (r < 0 || r >= rx || c < 0 || c >= cx || iarr[r][c]==0);
    }

}

class Axis{
	int r;
	int c;
	Axis(int r, int c){
		this.r = r;
		this.c = c;
	}
	public String toString() {
		return String.format("(%d, %d)", this.r, this.c);
	}
}
