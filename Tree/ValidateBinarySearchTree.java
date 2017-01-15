/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * */

package tree;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Integer maxNum = null;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
            
        boolean left = isValidBST(root.left);
        boolean middle;
        if(maxNum == null) {
            maxNum = root.val;
            middle = true;
        } else {
            if(root.val<=maxNum) {
                middle = false;
            } else {
                maxNum = root.val;
                middle = true;
            }
        }
        boolean right = isValidBST(root.right);
        return left && middle && right;
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