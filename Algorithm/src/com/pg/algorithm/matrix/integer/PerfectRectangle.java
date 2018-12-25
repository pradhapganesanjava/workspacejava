package com.pg.algorithm.matrix.integer;

public class PerfectRectangle {

	public static void main(String[] args) {
		
		int[][] rectangles =  new int[][] {{1,1,3,3},
				  {3,1,4,2},
				  {3,2,4,4},
				  {1,3,2,4},
				  {2,3,3,4}};
		
				  System.out.println(" "+		new Solution().isRectangleCover(rectangles));
	}

}


class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int lr = 0;
        int lc =0;
        int hr=0;
        int hc=0;
        System.out.println("input: "+rectangles);
        for(int i=0; i<rectangles.length; i++ ){
            
                int r1 = rectangles[i][0];
                int c1= rectangles[i][1];
                int r2= rectangles[i][2];
                int c2= rectangles[i][3];
                
                lr = Math.min(lr,r1);
                lc = Math.min(lc,c1);
                hr = Math.max(hr,r2);
                hc = Math.max(hc,c2);
                
                if(occupayCells(rectangles, r1,c1,r2,c2)){
                    continue;
                }else{
                    return false;
                }
        }
        System.out.println("output: "+rectangles);
        return occupayCells(rectangles, lr,lc,hr,hc);
    }
    
    private boolean occupayCells(int[][] arr, int lr, int lc, int hr, int hc){
        
        for(int i=lr; i<hr; i++){
            for(int j=lc; j<hc; j++){
                if(arr[i][j]!=1){
                    arr[i][j]=1;
                }else{
                    return false;
                }
                
            }
        }
        return true;
    }
    
}