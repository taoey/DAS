package LinkedList;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class IsRing {
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    /**
     * 判断一个单链表是否成环
     * @param root 根节点
     * @return
     */
    public boolean isRing(Node<?> root){
        Set<Object> set = new HashSet<Object>();
        Node<?> node=root;
        while(node.next!=null){
            if (!set.contains(node)){
                set.add(node);
                node = node.next;
            }else{
                break;
            }
        }

        if(node!=null){
            return true;
        }else{
            return false;
        }
    }

    @Test
    public void isRing(){
        Node<Integer> a = new Node<Integer>(null,1,null);
        Node<Integer> b = new Node<Integer>(null,2,null);
        Node<Integer> c = new Node<Integer>(null,3,null);

        a.next = b;
        b.next = c;
        c.next = b;//此时 b和c成环

        System.out.println(isRing(a));
    }

}
