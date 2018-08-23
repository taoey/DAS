package Leetcode206_reverseList;
/**
 * 
 * #206 链表翻转
 *
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Leetcode206_reverseList {
	
    public static ListNode reverseList(ListNode head) {
    	ListNode pre =null;
    	ListNode cur = head;
    	ListNode next = null;
    	while(cur!=null) {
    		next = cur.next;
    		cur.next=pre;
    		pre=cur;
    		cur=next;
    	}
		return pre;
    }
    
    public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		a.next=b;b.next=c;
		
		ListNode reverseList = reverseList(a);
		System.out.println(reverseList.val);
		
	}
}


