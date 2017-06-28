/*
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * */

package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if(root==null)
            return list;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(true) {
            if(root!=null) {
                stack.push(root);
                root = root.left;
            } else {
                if(stack.empty())
                    break;
                    
                root = stack.pop();
                list.add(root.val);
                root = root.right;
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