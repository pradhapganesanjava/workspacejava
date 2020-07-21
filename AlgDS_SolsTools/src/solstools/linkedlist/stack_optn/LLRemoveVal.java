package solstools.linkedlist.stack_optn;

/**
 * @author pradhapganesan
 *
 */
public class LLRemoveVal {

	public static void main(String[] args) {
		LLRemoveVal_Solution sol = new LLRemoveVal_Solution();
		sol.removeElements(null, 10);
	}

}

class LLRemoveVal_Solution {
	public ListNode removeElements(ListNode head, int val) {
		return linear(head, val);
	}

	private ListNode linear(ListNode head, int val) {
		ListNode rnd = new ListNode(-1);
		ListNode cnd = head;
		ListNode pnd = null;

		while (cnd != null) {
			if (cnd.val != val) {
				if (pnd == null) {
					rnd.next = cnd;
					pnd = rnd.next;
				} else {
					pnd.next = cnd;
					pnd = pnd.next;
				}
			} else if (cnd.next == null && pnd != null) {
				pnd.next = null;
			}
			cnd = cnd.next;
		}
		return rnd.next;
	}
}


class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}