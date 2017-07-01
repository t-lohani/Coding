/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
 * */

package tree;

public class BalancedBinaryTree {

	public static void main(String[] args) {

	}

	public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) == -1 ? false : true;
    }

    public static int checkBalance(TreeNode node){
        if (node == null) // case 2.2
            return 0;

        int left = checkBalance(node.left);
        if (left == -1) // check case 1
            return -1;

        int right = checkBalance(node.right);
        if (right == -1) // check case 1
            return -1;

        if (left - right > 1 || right - left > 1)
            return -1; // check case 2.1

        return (left > right ? left : right) + 1; // case 2.2
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}