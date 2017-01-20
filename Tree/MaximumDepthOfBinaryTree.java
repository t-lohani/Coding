/*
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * */

package tree;

public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		
	}

	public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return preOrder(root);
    }
    
    public int preOrder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + Math.max(preOrder(node.left), preOrder(node.right));
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