package com.pg.algorithm.linkedlist;

public class AddTwoNum {

	public static void main(String[] args) {
		ListNode l1 = retNewListNode(new int[]{2,4,3});
		ListNode l2 = retNewListNode(new int[] {5,6,4});
		addTwoNumbers(l1, l2);

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode retNode = new ListNode(0);
		ListNode currNode = null;
		currNode = retNode;
		int rem = 0;
		while (true) {
			boolean contLoop = false;
			int il1 = 0;
			int il2 = 0;

			if (null != l1) {
				contLoop = true;
				il1 = l1.val;
				l1 = l1.next;
			}

			if (null != l2) {
				contLoop = true;
				il2 = l2.val;
				l2 = l2.next;
			}

			if (contLoop == false)
				break;

			int newv = (il1 + il2 + rem) % 10;
			rem = (il1 + il2 + rem) / 10;
			if (currNode.next == null) {
				currNode.next = new ListNode(newv);
				currNode = currNode.next;
			}
		}

		return retNode;

	}

	private static ListNode retNewListNode(int[] iarr) {
		ListNode ln = new ListNode(iarr[0]);
		for (int i = 1; i < iarr.length; i++) {
			ln.next = new ListNode(iarr[i]);
		}
		return ln;
	}
}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}