package collection;

import org.junit.Test;

import java.util.*;

public class StackStudy {

    @Test
    public void  test00(){
        List<Integer> stack  = new ArrayList<Integer>();
        stack.add(1);
        stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
    }

    /**
     * 使用ArrayDeque实现栈的操作，把ArrayDeque的尾部作为栈顶
     */
    @Test
    public void test01(){
        Deque<Integer> stack  = new ArrayDeque<Integer>();
        //压栈操作
        stack.offer(1);
        stack.offer(2);
        stack.offer(4);
        System.out.println(stack);

        //获取栈顶元素，但不删除
        stack.peekLast();
        System.out.println(stack);
        //删除栈顶元素，并返回栈顶元素
        Integer integer = stack.pollLast();


        System.out.println(integer);
        System.out.println(stack);

    }

    /**
     * 使用双端链表实现队列的操作
     */
    @Test
    public void test02(){
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        Integer a = queue.peekFirst();
        System.out.println(a);

        System.out.println(queue);
        Integer b = queue.pollFirst();
        System.out.println(b);

        System.out.println(queue);
    }


}
