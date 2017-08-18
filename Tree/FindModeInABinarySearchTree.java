/*
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than or equal to the node's key.
    The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
    Both the left and right subtrees must also be binary search trees.

 * */

package tree;

import java.util.ArrayList;
import java.util.List;

public class FindModeInABinarySearchTree {

	public static void main(String[] args) {

	}

	public static List<Integer> list = new ArrayList<>();
	public static int maxCount = 0;
	public static int count = 0;
	public static int prev = 0;
    
    public static int[] findMode(TreeNode root) {
        inOrder(root);
        
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inOrder(node.left);
        
        if (node.val == prev) {
            count++;
        } else {
            count = 1;
            prev = node.val;
        }
        
        if (count == maxCount) {
            list.add(node.val);
        } else if (count > maxCount) {
            list = new ArrayList<>();
            list.add(node.val);
            maxCount = count;
        }
        
        inOrder(node.right);
    }
}
