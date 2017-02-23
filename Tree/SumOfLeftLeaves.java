/*
 * Find the sum of all left leaves in a given binary tree.
 * */

package tree;

public class SumOfLeftLeaves {

	public static void main(String[] args) {

	}

	public static int sumOfLeftLeaves(TreeNode root) {
        
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }
        
        return leftSum(root, true);
    }
    
    public static int leftSum(TreeNode node, boolean isLeft) {
        
        if (node == null) {
            return 0;
        }
        
        if (node.left==null && node.right==null && isLeft) {
            return node.val;
        }
        
        return leftSum(node.left, true) + leftSum(node.right, false);
    }
}

class TreeNode {
	int val;
	public TreeNode left;
	public TreeNode right;
	
	TreeNode(int x) {
		val = x;
	}
}
