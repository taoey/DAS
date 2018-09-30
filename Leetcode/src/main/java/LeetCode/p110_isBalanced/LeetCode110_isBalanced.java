package LeetCode110_isBalanced;
/**
 * 判断一个二叉树使用是平衡二叉树
 * @author tao
 *
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class LeetCode110_isBalanced {
	public boolean isBalanced(TreeNode root) {
        return getHeight(root) > -1;
    }
    public int getHeight(TreeNode node){
        if(node == null) return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if(Math.abs(left - right) > 1 || left == -1 || right == -1) return -1;
        return Math.max(left + 1, right + 1);
    }
}
