/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * */

package tree;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isMirror (root.left, root.right);
    }
    
    public boolean isMirror (TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        
        if (left.val == right.val) {
            return true && isMirror(left.left, right.right) && isMirror(left.right, right.left);
        } else {
            return false;
        }
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
