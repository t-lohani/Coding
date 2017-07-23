/*
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

to

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * */

package tree;

public class InvertABinaryTree {

	public static void main(String[] args) {

	}

	public static TreeNode invertTree(TreeNode root) {
        TreeNode tempVal;
        if(root != null) {
            tempVal = root.left;
            root.left = root.right;
            root.right = tempVal;    
                
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}