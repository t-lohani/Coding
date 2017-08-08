/*
 * You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
 * */

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

	public static void main(String[] args) {

	}

	public static List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> subQueue = new LinkedList<>();
        queue.add(root);
        int max = queue.peek().val;
        
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (max < temp.val) {
                max = temp.val;
            }
            
            if (temp.left!=null) {
                subQueue.add(temp.left);
            }
            
            if (temp.right!=null) {
                subQueue.add(temp.right);
            }
            
            if (queue.isEmpty() && !subQueue.isEmpty()) {
                queue = subQueue;
                subQueue = new LinkedList<>();
                answer.add(max);
                max = queue.peek().val;
            } else if (queue.isEmpty() && subQueue.isEmpty()) {
                answer.add(max);
            }
        }
        
        return answer;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}