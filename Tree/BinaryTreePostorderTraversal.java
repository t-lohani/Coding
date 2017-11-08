package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		
	}

	public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> answer = new LinkedList<>();
        
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                answer.addFirst(node.val);
                stack.add(node);
                node = node.right;
            } else {
                TreeNode popped = stack.pop();
                node = popped.left;
            }
        }
        
        return answer;
    }
}
