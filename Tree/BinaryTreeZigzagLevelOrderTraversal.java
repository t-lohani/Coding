/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

 * */

package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {

	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> inner = new ArrayList<Integer>();
        
        if(root==null)
            return answer;
            
        boolean leftTraversing = true;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.add(root);
        inner.add(root.val);
        answer.add(inner);
        inner = new ArrayList<Integer>();
        
        TreeNode temp;
        
        while(true) {
            temp = stack1.pop();
            
            if(leftTraversing) {
                if(temp.right!=null) {
                    stack2.add(temp.right);
                    inner.add(temp.right.val);
                }
                
                if(temp.left!=null)
                {
                    stack2.add(temp.left);
                    inner.add(temp.left.val);
                }
            } else {
                if(temp.left!=null)
                {
                    stack2.add(temp.left);
                    inner.add(temp.left.val);
                }
                
                if(temp.right!=null) {
                    stack2.add(temp.right);
                    inner.add(temp.right.val);
                }
            }
            
            if(stack1.empty() && stack2.empty())
                break;
            
            if(stack1.empty()) {
                leftTraversing = !leftTraversing;
                answer.add(inner);
                inner = new ArrayList<Integer>();
                stack1 = stack2;
                stack2 = new Stack<TreeNode>();
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