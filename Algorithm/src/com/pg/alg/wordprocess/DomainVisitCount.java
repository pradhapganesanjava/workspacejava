package com.pg.alg.wordprocess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainVisitCount {

	public static void main(String[] args) {
		DomainVisitCount.Solution sol = new DomainVisitCount().new Solution();
		List<String> strLst = sol.subdomainVisits(new String[] {"9001 discuss.leetcode.com"});
		strLst.forEach(ech -> System.out.println(ech));
	}

	class Solution {
	    public List<String> subdomainVisits(String[] cpdomains) {
	        
	        if(null == cpdomains || cpdomains.length == 0) return new ArrayList<String>();
	        
	        Map<String, Integer> resMp = new HashMap<>();
	        
	        // strSplitWay(cpdomains, resMp);
	        
	        strIndexOfWay(cpdomains, resMp);
	        
	        List<String> resLst = new ArrayList<>();
	        for(String key : resMp.keySet()){
	            resLst.add(resMp.get(key)+" "+key);
	        }
	        return resLst;
	    }

		private void strIndexOfWay(String[] cpdomains, Map<String, Integer> resMp) {

			for(String str: cpdomains) {
				
				int splitIdx = str.indexOf(" ");
				String cntStr = str.substring(0,splitIdx);
				String domStr = str.substring(splitIdx+1);
				
				Integer cnt = Integer.parseInt(cntStr);
				putMp(resMp, domStr, cnt);
				
				int dtIdx = 0; 
				String subDom = domStr;
				
				while( (dtIdx = subDom.indexOf(".")) > -1) {
					subDom = subDom.substring(dtIdx+1);
					putMp(resMp, subDom, cnt);
				}
			}
		}

		private void strSplitWay(String[] cpdomains, Map<String, Integer> resMp) {
			for(String cpdom : cpdomains){
	            
	            String[] splt = cpdom.split("\\ ");
	            String str0 = splt[0];
	            Integer icnt = Integer.parseInt(str0);
	            String str1 = splt[1];
	            
	            putMp(resMp, str1, icnt);
	            
	            String[] domStr = splt[1].split("\\.");
	            int domStrLen = domStr.length;
	           
	            int cnt = domStrLen-1;
	            int n = 1;
	            while(cnt>0){
	                StringBuilder strb = new StringBuilder();
	                for(int i=n; i<domStrLen;i++){
	                    strb.append(domStr[i]);
	                    if(i+1<domStrLen){
	                        strb.append(".");
	                    }
	                }
	                
	                String nstr = strb.toString();
	                
	                putMp(resMp, nstr, icnt);
	                n++;
	                cnt--;
	                strb.setLength(0);
	            }

	           
	        }
		}
	    
	    private void putMp(Map<String, Integer> mp, String key, Integer val){
	        if(mp.containsKey(key)){
	                mp.put(key, mp.get(key) + val);
	        }else{
	                mp.put(key, val);
	        }
	    }
	}
}
