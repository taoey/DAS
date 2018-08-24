package MyBinaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 节点类
 * @param <T>
 */
class Node<T>{
    private Node<T> left;  //左孩子
    private Node<T> right; //右孩子
    private T data;        //当前节点存储的数据

    public Node(T data){
        this(null,data,null);
    }

    public Node(Node<T> left,T data,Node<T> right) {
        this.right = right;
        this.data = data;
        this.left = left;
    }

    public Node<T> getLeft() {
        return left;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Node<T> getRight() {
        return right;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }

}

/**
 * 二叉树类
 * @param <T>
 */
public class BinaryTree<T> {

    private ArrayList<T> postNodes = null;
    public BinaryTree(){
        postNodes = new ArrayList<T>();
    }
    public ArrayList<T> getPostNodes() {
        return postNodes;
    }

    /**
     * 创建一颗二叉树
     * @return
     */
    public Node<String> createTree(){
        // 该树图像：https://upload-images.jianshu.io/upload_images/1115031-166475e6c9153b39.png
        //二叉树层序遍历：ABOCSMQWK  共9个节点
        Node<String> W = new Node<String>("W");
        Node<String> K = new Node<String>("K");
        Node<String> C = new Node<String>(W,"C",K);
        Node<String> S = new Node<String>("S");
        Node<String> B = new Node<String>(C,"B",S);
        Node<String> M = new Node<String>("M");
        Node<String> Q = new Node<String>("Q");
        Node<String> O = new Node<String>(M,"O",Q);
        Node<String> A = new Node<String>(B,"A",O);
        return A;
    }

    /**
     * 访问节点的方法
     * @param node
     */
    public void visitNode(Node<T> node){
        System.out.print(node.getData());
    }

    /**
     * 前序遍历
     * @param root
     */
    public void preVisit(Node<T> root){
        if(root!=null){
            visitNode(root);
            preVisit(root.getLeft());
            preVisit(root.getRight());
        }

    }

    /**
     * 非递归前序遍历, 非递归中序和后序遍历其实大体类似，第一个入栈的是先遍历的
     * 例如：
     *  前序：root
     *  中序：root.left
     *  后序：root.right
     *
     *  还要注意非null判断（我写的这个算法实际上把null也添加进了栈中）
     * @param root
     */
    public void preVisitByStack(Node<T> root){
        Stack<Node> stack  = new Stack<Node>();
        stack.add(root);
        while(!stack.empty()){
            Node head = stack.pop();
            if(head!=null){
                System.out.print(head.getData());
                stack.push(head.getRight());
                stack.push(head.getLeft());
            }
        }

    }



    /**
     * 中序遍历
     * @param root
     */
    public void visit(Node<T> root){
        if(root!=null){
            visit(root.getLeft());
            visitNode(root);
            visit(root.getRight());
        }

    }

    /**
     * 后序遍历  访问节点的方法
     * @param node
     */
    private void postVisitNode(Node<T> node){
        postNodes.add(node.getData());
    }

    /**
     * 后序遍历，将结果保存到了成员变量postNodes中
     * @param root
     */
    public void postVisit(Node<T> root){
        if (root!=null){
            postVisit(root.getLeft());
            postVisit(root.getRight());
            postVisitNode(root);
            //visitNode(root);
        }
    }

    /**
     * 利用对队列实现
     * @param root
     */
    public void levelVisit(Node<T> root){
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node<T> head = queue.poll();
            if(head!=null){
                System.out.print(head.getData());
                queue.add(head.getLeft());
                queue.add(head.getRight());
            }
        }
    }

    public static void main(String[] args) {

        BinaryTree myBinaryTree = new BinaryTree();
        //创建了一颗二叉树
        Node root = myBinaryTree.createTree();

        /*前序遍历*/
        myBinaryTree.preVisit(root);
        System.out.println();
        myBinaryTree.preVisitByStack(root);

        /*中序遍历*/
        //myBinaryTree.visit(root);

        /*后序遍历*/
        //myBinaryTree.postVisit(root);

        /*层序遍历*/
        //myBinaryTree.levelVisit(root);





    }
}
