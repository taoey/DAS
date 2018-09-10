package beike.P1;

import java.util.Scanner;

/**
 * Created by tao on 2018/9/3.
 */
class Node{
    int a;
    int b;

    public Node(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
class TreeNode{
    int val;
    int father;

    public TreeNode(int val, int father) {
        this.val = val;
        this.father = father;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getFather() {
        return father;
    }

    public void setFather(int father) {
        this.father = father;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] nodes = new Node[n];
        TreeNode[] tree = new TreeNode[n];
        for(int i=0;i<n;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            nodes[i] = new Node(a,b);
        }
        //找出父节点
        for (int i = 0; i < n; i++) {
            if (nodes[i].getA()==-1){
                tree[i] = new TreeNode(nodes[i].getB(),nodes[i].getA());
            }else if (nodes[i].getB()==-1){
                tree[i] = new TreeNode(nodes[i].getA(),nodes[i].getB());
            }
        }



    }
}
