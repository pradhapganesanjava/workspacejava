package com.pg.alg.linkedlist;

public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers this_  = new AddTwoNumbers();
		ListNode l1 = this_.convertToLL(9);
		ListNode l2 = this_.convertToLL(9999999991l);
		ListNode lsum = this_.addTwoNumbersOVERFLOW(l1, l2); // WRONG DONT DO THIS WAY
	}
    public ListNode addTwoNumbersOVERFLOW(ListNode l1, ListNode l2) {
        
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        long l1Int = convertToInt(l1);
        long l2Int = convertToInt(l2);
        long sum = (long)(l1Int + l2Int);
        if(sum==0) return new ListNode(0);
        return convertToLL(sum);
        
    }
    private ListNode convertToLL(long sum){
        ListNode headNd = null;
        ListNode lastNd = null;
        long d = 10;
        while(sum>0){
            int i = (int)(sum%d);
            if(headNd == null){
                headNd = new ListNode(i);
                lastNd = headNd;
            }else{
                lastNd.next = new ListNode(i);
                lastNd = lastNd.next;
            }
            sum = sum/d; 
        }
        return headNd;
    }
    
    private long convertToInt(ListNode ln){
        long resInt = 0;
        int d = 1;
        ListNode curNd = ln;
        
        while(curNd != null){
            resInt = (long)resInt + (long)(curNd.val * d);
            curNd = curNd.next;
            d *= 10;
        }
        return resInt;
    }
	    
	    private class ListNode {
	    	      int val;
	    	     ListNode next;
	    	      ListNode(int x) { val = x; }
	    	  }
}
