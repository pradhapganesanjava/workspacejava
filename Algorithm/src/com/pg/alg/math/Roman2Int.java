package com.pg.alg.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Roman2Int {

	public static void main(String[] args) {
		System.out.println(romanToInt("IV"));
		
		List<String> strLst = new ArrayList<>();
		String str = "zamnbopc";
		char[] cArr = str.toCharArray();
		Arrays.sort(cArr);
		System.out.println(Arrays.toString(cArr));
	}

	 public static int romanToInt(String s) {
	        
	        if(null == s || "".equals(s)) return 0;
	        
	        Map<String, Integer> rmp = new HashMap<>();
	        rmp.put("I",1);
	        rmp.put("V",5);
	        rmp.put("X",10);
	        rmp.put("L",50);
	        rmp.put("C",100);
	        rmp.put("D",500);
	        rmp.put("M",1000);
	        rmp.put("IV",4);
	        rmp.put("IX",9);
	        rmp.put("XL",40);
	        rmp.put("XC",90);
	        rmp.put("CD",400);
	        rmp.put("CM",900);
	        
	        int num = 0;
	        String rom = "";
	        
	        for(int i=0; i<s.length(); i++){
	            String c = String.valueOf(s.charAt(i));
	            rom = c;
	            if("ICX".indexOf(c)>-1 && i+1<s.length() && rmp.keySet().contains(rom+s.charAt(i+1))){
	                num+=rmp.get(rom+s.charAt(i+1));
	                i+=1;
	            }else{
	                num+=rmp.get(rom);
	            } 
	        }
	        
	        return num;
	        
	    }
}
