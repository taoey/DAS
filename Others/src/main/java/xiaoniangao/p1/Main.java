package xiaoniangao.p1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    //节点
    private  class Node{
        public Integer value;
        public Node next;

        public Node(){
            value = null;
            next = null;
        }
    }

    //处理方法
    public Node addNodeList(Node aRoot,Node bRoot){
        Node result = new Node();

        Deque<Node> aStack = new ArrayDeque<>();

        Node aPoint = aRoot;
        while(aPoint !=null ){
            aStack.offer(aPoint);
            aPoint = aPoint.next;
        }

        Deque<Node> bStack = new ArrayDeque<>();

        Node bPoint = bRoot;
        while(bPoint != null){
            bStack.offer(bPoint);
            bPoint = bPoint.next;
        }

        int count = Math.max(aStack.size(),bStack.size());
        for(int i =0;i<count;i++){
            //
        }

        return  result;
    }


}
