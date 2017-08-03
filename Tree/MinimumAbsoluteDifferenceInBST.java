/*
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.
 * */

package tree;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

	public static void main(String[] args) {
		
	}

	public static List<Integer> list = new ArrayList<>();
    public static int getMinimumDifference(TreeNode root) {
        double answer = Math.pow(2, 32);
        inOrder(root);
        
        for (int i=1; i<list.size(); i++) {
            if (list.get(i)-list.get(i-1) < answer) {
                answer = list.get(i)-list.get(i-1);
            }
        }
        
        return (int) answer;
    }
    
    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}