/*
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * */

package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		
	}

	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if(root==null)
            return list;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        TreeNode temp;
        
        while(!stack.empty()) {
            temp = stack.pop();
            list.add(temp.val);
            
            if(temp.right!=null) {
                stack.push(temp.right);
            }
            
            if(temp.left!=null) {
                stack.push(temp.left);
            }
        }
        
        return list;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
