package com.pg.algorithm.recursion;

public class ClosestNextTime {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.nextClosestTime("23:59"));
	}

}
class Solution {
	public String nextClosestTime(String time) {

		if (null == time || "".equals(time.trim()) || time.length() < 5)
			return time;

		StringBuffer strb = new StringBuffer();
		String time4 = time.substring(0, 2) + time.substring(3, 5);
		String nTime =  nextCloseTimeRecur(time4, strb);
        return nTime.substring(0, 2) +":" + nTime.substring(2, 4);

	}

	private String nextCloseTimeRecur(String time, StringBuffer strb) {

		if (strb.length() == 4) {
			return checkValid(strb.toString());
		}
		String bestNxtTime = null;
		for (int i = 0; i < 4; i++) {
			if( (strb.length()==0 && Integer.valueOf(String.valueOf(time.charAt(i))) > 2) 
					||  (strb.length()==2 && Integer.valueOf(String.valueOf(time.charAt(i))) > 5) ) {
				continue;
			}
			strb.append(time.charAt(i));
			String nxtTime = nextCloseTimeRecur(time, strb);
			if (nxtTime != null) {
                if(bestNxtTime == null){
                    bestNxtTime = nxtTime;
                }else{
				    bestNxtTime = findBest(bestNxtTime, nxtTime, time);
                }
			}
			if (strb.length() > 0) {
				strb.setLength(strb.length() - 1);
			}
		}
		System.out.println("return bestNxtTime "+ bestNxtTime);
		return bestNxtTime;
	}

	private String checkValid(String time) {
		if (null == time || "".equals(time.trim()) || time.length() < 4)
			return null;
		Integer hr = Integer.valueOf(time.substring(0, 2));
		Integer m = Integer.valueOf(time.substring(2, 4));

		if (hr > 23 || hr < 1 || m > 59 || m < 1) {
			return null;
		} else {
			return time;
		}
	}

	private String findBest(String bTime, String nTime, String time) {
		if (null == nTime || "".equals(nTime.trim()) || nTime.length() < 4)
			return null;
		if (null == bTime || "".equals(bTime.trim()) || bTime.length() < 4)
			return null;

		Integer hr = Integer.valueOf(time.substring(0, 2));
		Integer m = Integer.valueOf(time.substring(2, 4));

		Integer bhr = Integer.valueOf(bTime.substring(0, 2));
		Integer bm = Integer.valueOf(bTime.substring(2, 4));
		int bHrDiff = 0;
		int bMDiff = 0;
		if (bhr <= hr) {
			bHrDiff = (23 - hr) + bhr;
		} else {
			bHrDiff = bhr - hr;
		}

		if (bm <= m) {
			bMDiff = (59 - m) + bm;
		} else {
			bMDiff = bm - m;
		}
		int bDiff = bHrDiff + bMDiff;

		Integer nhr = Integer.valueOf(nTime.substring(0, 2));
		Integer nm = Integer.valueOf(nTime.substring(2, 4));
		int nHrDiff = 0;
		int nMDiff = 0;
		if (nhr <= hr) {
			nHrDiff = (23 - hr) + nhr;
		} else {
			nHrDiff = nhr - hr;
		}

		if (nm <= m) {
			nMDiff = (59 - m) + nm;
		} else {
			nMDiff = nm - m;
		}

		int nDiff = nHrDiff + nMDiff;
		
		if (nDiff ==0) {
			return bTime;
		} else if (bDiff ==0) {
			return nTime;
		}
		
		if (nDiff < bDiff) {
			return nTime;
		} else {
			return bTime;
		}
	}
}