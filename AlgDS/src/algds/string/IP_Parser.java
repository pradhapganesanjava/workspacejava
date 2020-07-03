package algds.string;

import java.util.Arrays;

public class IP_Parser {
	static IP_Parser_Solution sol = new IP_Parser_Solution();
	public static void main(String[] args) {
		sol.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:666");

	}

}

class IP_Parser_Solution {
    public String validIPAddress(String IP) {
        return splitValidate(IP);
    }
    final String NA = "Neither";
    final String IP4 = "IPv4";
    final String IP6 = "IPv6";
    
    private String splitValidate(String ip){
        if(ip == null || "" == ip.trim()){
            return NA;
        }   
        if(ip.indexOf(".") > 0 && checkIp4(ip)){
            return IP4;
        }else if(ip.indexOf(":") > 0 && checkIp6(ip)){
            return IP6;
        }
        return NA;
    }
    
    private boolean checkIp4(String ip){
        String[] sarr = ip.split("\\.");
        System.out.println("b4 sarr : "+ Arrays.toString(sarr));
        if(sarr.length != 4){
            return false;
        }
        System.out.println("sarr : "+ Arrays.toString(sarr));
        for(int i=0; i<sarr.length; i++){
            String s = sarr[i];
            System.out.println("ip4 : "+s.indexOf(0)+" == ? " + (s.indexOf(0)=='0'));
            if("" == s.trim() || (s.length() > 1 && s.charAt(0)=='0')){
                return false;
            }
            Integer ival = -1;
            try{
                ival = Integer.valueOf(s);
                 if(ival>255){
                     return false;
                 }
            }catch(Exception e){
                return false;
            }
        }
        return true;
    }
    
    private boolean checkIp6(String ip){
        String[] sarr = ip.split(":");
        if(sarr.length != 8){
            return false;
        }
        for(int i=0; i<sarr.length; i++){
            String s = sarr[i];
            if("" == s.trim() || s.length() > 4){
                return false; }
            for(int j=0; j<s.length(); j++){
                if("abcdefABCDEF0123456789".indexOf(String.valueOf(s.charAt(j))) == -1){
                    return false;
                }
            }
        }
        return true;
    }
}