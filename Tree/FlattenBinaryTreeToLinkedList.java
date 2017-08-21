/*
 *  Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

 * */

package tree;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		
	}

	public static void flatten(TreeNode node) {

        if(node==null){
            return;
        }
        flatten(node.left);
        flatten(node.right);
        TreeNode left = node.left;
        TreeNode right = node.right;
        if(left == null){
            return;
        }
        node.right = left;
        node.left = null;
        TreeNode temp = left;
        while(temp.right != null){
            temp = temp.right;
        }
        temp.right = right;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}