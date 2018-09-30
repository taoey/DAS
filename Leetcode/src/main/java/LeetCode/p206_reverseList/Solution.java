package LeetCode.p206_reverseList;

import org.junit.Test;

public class Solution {
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
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
    @Test
    public  void test00() {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		a.next=b;b.next=c;
		
		ListNode reverseList = reverseList(a);
		System.out.println(reverseList.val);
		
	}
}


