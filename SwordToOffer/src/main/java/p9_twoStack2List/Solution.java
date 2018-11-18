package p9_twoStack2List;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //push的元素存放在stack1中
    public void push(int node) {
        stack1.push(node);
    }
    //处理之后的元素存放在stack2中
    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}