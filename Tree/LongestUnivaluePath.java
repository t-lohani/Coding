package tree;

public class LongestUnivaluePath {

	static int answer = 0;
    public static int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        
        postOrder(root);
        
        return answer;
    }
    
    public static int postOrder(TreeNode node) {
    	int left = node.left == null ? 0 : postOrder(node.left);
        int right = node.right == null ? 0 : postOrder(node.right);
        
        int newLeft = (node.left != null) && (node.left.val == node.val) ? left + 1 : 0;
        int newRight = (node.right != null) && (node.right.val == node.val) ? right + 1 : 0;
        
        answer = Math.max(answer, newLeft+newRight);
        
        return Math.max(newLeft, newRight);
    }
}
