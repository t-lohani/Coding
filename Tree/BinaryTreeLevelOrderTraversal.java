/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * */

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
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
        
        return answer;
    }
}
