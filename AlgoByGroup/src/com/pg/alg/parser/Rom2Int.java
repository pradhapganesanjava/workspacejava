package com.pg.alg.parser;

import java.util.HashMap;
import java.util.Map;

public class Rom2Int {

	public static void main(String[] args) {
		Rom2IntSolution r2i = new Rom2IntSolution();
		String r = "XXXIVI";
		int i = r2i.romanToInt(r);
		System.out.format("%s, %d \n", r, i);
		
	}

}

class Rom2IntSolution {
    public int romanToInt(String s) {
        
        if(s == null) return -1;
        
        
String[][] r2iArr= new String[][]{
    {"1","I"},{"2","II"},{"3","III"},{"4","IV"},{"5","V"},{"6","VI"},{"7","VII"},{"8","VIII"},{"9","IX"},
    {"10","X"},{"20","XX"},{"30","XXX"},{"40","XL"},{"50","L"},{"60","LX"},{"70","LXX"},{"80","LXXX"},{"90","XC"},
    {"100","C"},{"200","CC"},{"300","CCC"},{"400","CD"},{"500","D"},{"600","DC"},{"700","DCC"},{"800","DCCC"},{"900","CM"},
    {"1000","M"},{"2000","MM"},{"3000","MMM"},{"4000","NA"},{"5000","NA"},{"6000","NA"},{"7000","NA"},{"8000","NA"},{"9000","NA"},
};       
        
        Map<String, Integer> mp = new HashMap<>();
        
        for(int r = 0; r<r2iArr.length; r++){
            mp.put(r2iArr[r][1],Integer.valueOf(r2iArr[r][0]));
        }
        
        if(s.length() == 1) return mp.get(s);
        
        int lf = 0;
        int len = s.length();
        int rt = 1;
        int num = 0;
        /*
        while(lf < rt && rt<=len){
            if(!mp.containsKey(s.substring(lf,rt))){
                //if(lf<rt-1){
                    rt--;
                    num+= mp.get(s.substring(lf,rt));
                    lf = rt;
                //}
            }
            if(rt+1 == len){
                num+= mp.get(s.substring(lf,rt+1));
            }            
            rt++;
        } 
         return num == 0?mp.get(s):num;
        */
        while(rt <= len){
            int trt = rt;
            while(trt <=len && mp.containsKey(s.substring(lf,trt))){
                trt++;
            }
            rt = rt >= trt-1? rt : trt-1;
                  
            if(mp.containsKey(s.substring(lf,rt))){
                num+= mp.get(s.substring(lf,rt));
            }else{
                return -1;
            }
               
           lf= rt;
           rt++;
        }
       return num;
    }
}