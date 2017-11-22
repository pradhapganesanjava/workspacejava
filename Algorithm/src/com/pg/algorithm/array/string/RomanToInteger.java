package com.pg.algorithm.array.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//with additional array space and left to right
	 public int romanToInt(String s,int nums[]) {
		    nums = new int[s.length()];
		    for(int i=0;i<s.length();i++){
		        switch (s.charAt(i)){
		            case 'M':
		                nums[i]=1000;
		                break;
		            case 'D':
		                nums[i]=500;
		                break;
		            case 'C':
		                nums[i]=100;
		                break;
		            case 'L':
		                nums[i]=50;
		                break;
		            case 'X' :
		                nums[i]=10;
		                break;
		            case 'V':
		                nums[i]=5;
		                break;
		            case 'I':
		                nums[i]=1;
		                break;
		        }
		    }
		    int sum=0;
		    for(int i=0;i<nums.length-1;i++){
		        if(nums[i]<nums[i+1])
		            sum-=nums[i];
		        else
		            sum+=nums[i];
		    }
		    return sum+nums[nums.length-1];
		}
	 
	 /**
	  * with HashMap and right to left Iteration
	  * @param s
	  * @return
	  */
	    public int romanToInt(String s) {
	        
	        if(null == s || "".equals(s.trim())){return -1;}
	        
	        Map<Character,Integer> map = new HashMap<>();
	        map.put('I',1);
	        map.put('V',5);
	        map.put('X',10);
	        map.put('L',50);
	        map.put('C',100);
	        map.put('D',500);
	        map.put('M',1000);
	        
	        char[] rc = s.toCharArray();
	        int len = rc.length;
	        int last = 0;
	        int curr = 0;
	        int ret = map.get(rc[len-1]);;
	        for(int i = len-1; i>=0; i--){
	            
	            if(i+1 < len ){
	                last = map.get(rc[i+1]);
	            }else{
	                continue;
	            }
	            curr = map.get(rc[i]);
	            
	            if(last <= curr){
	                ret += curr;
	            }else{
	                ret -= curr;
	            }
	                    
	            
	        }
	        return ret;
	        
	    }
	 
}
