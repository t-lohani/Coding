/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

 * */

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {

	public static void main(String[] args) {

	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if(root==null)
            return answer;
            
        Queue<TreeNode> mainQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> subsQueue = new LinkedList<TreeNode>();
        
        mainQueue.add(root);
        
        TreeNode popped;
        List<Integer> interim = new ArrayList<Integer>();
        interim.add(root.val);
        answer.add(interim);
        interim = new ArrayList<Integer>();
        
        while(!mainQueue.isEmpty()) {
            popped = mainQueue.remove();
            
            if(popped.left!= null) {
                subsQueue.add(popped.left);                
                interim.add(popped.left.val);
            }
            if(popped.right!= null) {
                subsQueue.add(popped.right);
                interim.add(popped.right.val);
            }
                
            if(mainQueue.isEmpty() && !subsQueue.isEmpty()) {
                mainQueue = subsQueue;
                subsQueue = new LinkedList<TreeNode>();
                answer.add(interim);
                interim = new ArrayList<Integer>();
            }
        }
        
        int head = 0, tail = answer.size()-1;
        
        while(tail > head) {
            interim = answer.get(head);
            answer.set(head, answer.get(tail));
            answer.set(tail, interim);
            head++;
            tail--;
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