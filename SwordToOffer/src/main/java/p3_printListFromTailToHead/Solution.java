package p3_printListFromTailToHead;


import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 从尾到头打印链表
 */
public class Solution {
    /**
     * 链表节点
     */
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 翻转链表，从尾到头输出（不改变原有链表结构，使用栈）
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        //使用双端链表充当栈
        Deque<ListNode> stack = new ArrayDeque<ListNode>();

        ListNode current = listNode;
        while(current!=null){
            stack.offer(current);
            current = current.next;
        }
        while (!stack.isEmpty()){
            result.add(stack.pollLast().val);
        }

        return result;
    }

    @Test
    public void test00(){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next=b;
        b.next=c;
        ArrayList<Integer> integers = printListFromTailToHead(a);
        System.out.println(integers);

    }

}
