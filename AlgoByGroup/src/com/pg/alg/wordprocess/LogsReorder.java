package com.pg.alg.wordprocess;

import java.util.Arrays;

public class LogsReorder {

	public static void main(String[] args) {

		LogsReorderSolution sol = new LogsReorderSolution();
		String[] logs = new String[] {
				"g1 act car","g2 act car","a1 act car","g1 act aar"			
		};
		sol.reorderLogFiles(logs);
		System.out.println(Arrays.toString(logs));
		
		logs = new String[] {
				"a1 9 2 3 1","g1 act car","zo4 4 7","aa4 4 7","ab1 off key dog","a8 act zoo","g2 act car","a1 act car","g1 act aar"			
		};
		//sol.reorderLogFiles(logs);
		System.out.println(Arrays.toString(logs));
	}

}

class LogsReorderSolution {
    public String[] reorderLogFiles(String[] logs) {
        
        if(null == logs || logs.length <= 1) return logs;
        return secondTry(logs);
        // return earlierImpl(logs);
    }
    
    private String[] secondTry(String[] logs){
    
        Arrays.sort(logs, this::secondSrt);
        return logs;
    }
    
    private int secondSrt(String a, String b){
        int ia = a.indexOf(" ");
        int ib = b.indexOf(" ");
        
        String as1 = a.substring(0, ia);
        String as2 = a.substring(ia+1, a.length());
        String bs1 = b.substring(0, ib);
        String bs2 = b.substring(ib+1, b.length());
        
        if(Character.isAlphabetic(as2.charAt(0)) && Character.isAlphabetic(bs2.charAt(0))){
            int comp = as2.compareTo(bs2);
            return (comp == 1) ? as1.compareTo(bs1) : comp;
        }else if(Character.isDigit(as2.charAt(0)) || Character.isDigit(bs2.charAt(0))){
            return Character.isDigit(as2.charAt(0)) ? 1 : -1;
        }else{ //if(Character.isDigit(as2.charAt(0)) && Character.isDigit(bs2.charAt(0))){
            return 1;
        }
        
    }
}
