package com.pg.algorithm.array.integer;

public class SuperPow {

	public static void main(String[] args) {

	}

}

class SuperPowSolution {
    
    int mBuf[] = new int[100];
    int mul10 = 1;
    int mulRes = 1;
    int bufInd = 9;
    public int superPow(int a, int[] b) {
        return superPowRecur(a, b,bufInd);
    }
	private int superPowRecur(int a, int[] b, int bufInd) {
		if(bufInd==0){ return 1;}
		if(bufInd==1){ return 2;}
		for(int i=0; i< b.length; i++){
            if(i!=0){
                mul10 = mul10 * 10;
            }else{
                mul10 = 1;
            }
            int x = b[i];
            while(x > 0){
                bufInd += i;
                if(mBuf[bufInd+i] != 0){
                    mulRes = mBuf[bufInd] * mulRes;
                }else{
                	mBuf[bufInd] = superPow(x, new int[]{bufInd-1});
                }
                x = x-mul10;
            }
        }
        return mulRes;
	}
}