/*
 * Given a binary tree, find the leftmost value in the last row of the tree. 
 * */

package tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

	public static void main(String[] args) {
		
	}

	public static int findBottomLeftValue(TreeNode root) {
        int answer = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> subs = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (isLeft) {
                isLeft = false;
                answer = temp.val;
            }
            
            if (temp.left!=null) {
                subs.add(temp.left);
            }
            
            if (temp.right!=null) {
                subs.add(temp.right);
            }
            
            if (queue.isEmpty() && !subs.isEmpty()) {
                queue = subs;
                subs = new LinkedList<>();
                isLeft = true;
            }
        }
        
        return answer;
    }
}


public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}