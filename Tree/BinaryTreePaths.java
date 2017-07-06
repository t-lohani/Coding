/*
 *  Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

["1->2->5", "1->3"]
 * */

package tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

	public static void main(String[] args) {
		
	}

	public static List<String> result = new LinkedList<String>();
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        childBinaryTreePath(root, "");

        return result;
    }

    public static void childBinaryTreePath(TreeNode root, String path) {
        path += root.val;

        if (root.left == null && root.right == null) {
            result.add(path);
        } 
        if (root.left != null) {
            childBinaryTreePath(root.left, path + "->");
        }
        if (root.right != null) {
            childBinaryTreePath(root.right, path + "->");
        }
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}