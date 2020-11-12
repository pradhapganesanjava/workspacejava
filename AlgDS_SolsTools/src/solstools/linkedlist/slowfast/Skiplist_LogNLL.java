package solstools.linkedlist.slowfast;

public class Skiplist_LogNLL {

	public static void main(String[] args) {
		Skiplist sol = new Skiplist();
		sol.add(1);
		sol.add(2);
		sol.add(3);
		sol.add(10);
		sol.add(5);
		sol.add(12);
		System.out.println(sol.search(5));
		System.out.println(sol.erase(5));
		System.out.println(sol.search(5));
	}

}
class  Skiplist{
    
    ListNode head = null;
    ListNode tail = null;
    public Skiplist(){
        head = new ListNode();
        tail = head;
    }
    
    public boolean search(int tgt) {
       ListNode cnd = getPreNode(tgt);
        ListNode pre = cnd;
       while(cnd != null && cnd.val < tgt){
           pre = cnd;
           cnd = cnd.next;
       }
       return cnd!=null && cnd.val == tgt;
    }
    
    public void add(int num) {
       ListNode cnd = getPreNode(num);
       ListNode pre = cnd;
       while(cnd != null && cnd.val < num){
           pre = cnd;
           cnd = cnd.next;
       }   
       ListNode nnd = new ListNode(num);
       pre.next = nnd;
       nnd.next = cnd;
       if(cnd == null){
           tail = nnd;
       }
    }
    
    public boolean erase(int num) {
       ListNode cnd = getPreNode(num);
       ListNode pre = cnd;
       while(cnd != null && cnd.next!=null && cnd.next.val <= num){
           pre = cnd;
           cnd = cnd.next.next;
       }   
       if(pre != null && pre.next != null && pre.next.val == num){
           pre.next = cnd;
           if(cnd == null){
            tail = pre;
           }
           return true;
       }
      return false;
    }
    
    private ListNode getPreNode(int num){
        if(head.next == null){
            return head;
        }
        ListNode cnd = head.next;
        if(num < cnd.val){
            return cnd;
        }else if(num >= tail.val){
            return tail;
        }
        ListNode fast = cnd;
        ListNode pre = cnd;
        while(fast != null && fast.next != null){
            if(fast.val > num){
                break;
            }
            pre = fast;
            fast = fast.next.next;
        }
        return pre;
    }
    
}

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(){
        
    }
    public ListNode(int v){
        this.val = v;
    }
}
