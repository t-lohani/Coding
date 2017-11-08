package tree;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {

	}

	static int answer = Integer.MIN_VALUE;
    
    public static int maxPathSum(TreeNode root) {
        postOrder(root);
        return answer;
    }
    
    public static int postOrder(TreeNode node) {
        if (node == null)
            return 0;
        
        int left = Math.max(0, postOrder(node.left));
        int right = Math.max(0, postOrder(node.right));
        answer = Math.max(answer, node.val + left + right);
        return Math.max(left, right) + node.val;
    }
}
