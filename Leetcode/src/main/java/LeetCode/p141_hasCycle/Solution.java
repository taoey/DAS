package LeetCode.p141_hasCycle;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个链表是否有环，最好不使用额外的空间
 */
public class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 使用快慢指针的方法进行
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //注意，这里使用了&&的左侧先匹配原则，应把最早可以实现的放到最右边
        while(slow!=null && fast!=null && fast.next!=null){
            if(fast==slow){
                return true;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }

    /**
     * 使用一个set集合
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if(head==null){
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode cur =head;
        while(cur!=null){
            if(set.contains(cur)){
                return true;
            }
            set.add(cur);
            cur=cur.next;
        }
        return false;
    }

    @Test
    public void test00(){
        ListNode a =new ListNode(1);
        ListNode b =new ListNode(1);
        ListNode c =new ListNode(1);
        ListNode d =new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        boolean result1 = hasCycle(a);
        boolean result2 = hasCycle2(a);
        System.out.println(result1);
        System.out.println(result2);
    }

}