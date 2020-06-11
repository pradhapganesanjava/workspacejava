package com.pg.alg.linkedlist.transform;

public class LL_Transform_Reverse {

	public static void main(String[] args) {
		
		LLNode head = LLNode.create(1,2,3,4,5,6);
		System.out.println("INPUT: ");
		LLNode.print(head);
		head = reverse(head);
		System.out.println("REVERSED: ");
		LLNode.print(head);
	}
	
	public static LLNode reverse(LLNode head) {
		if(head == null) return null;
		
		LLNode pv = head;
		LLNode cn = head.next;
		
		while(cn != null){
			LLNode nxt = cn.next;
			cn.next = pv;
			pv=cn;
			cn=nxt;
		}
		head.next = null;
		return pv;
	}
	
	

}

class LLNode{
	public int val;
	public LLNode next;
	
	public static void print(LLNode nd) {
		if(nd == null) {
			return;
		}
		while(nd != null) {
			System.out.format(" %d ",nd.val);
			if(null != nd.next) {
				System.out.print("->");
			}else {
				System.out.println();
			}
			nd = nd.next;
		}
	}
	
	public static LLNode create(Integer...iarr) {
		if(iarr == null || iarr.length == 0) return null;
		LLNode head = new LLNode();
		head.val = iarr[0];
		LLNode cnd = head;
		for(int i=1; i<iarr.length; i++) {
			LLNode nnd = new LLNode();
			nnd.val = iarr[i];
			cnd.next = nnd;
			cnd = nnd;
		}
		return head;
	}
	
	public String toString() {
		return String.valueOf(this.val);
	}
}