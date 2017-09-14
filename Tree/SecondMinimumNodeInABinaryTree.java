package tree;

public class SecondMinimumNodeInABinaryTree {

	public static int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return -1;
        
        int left = (root.left != null && root.left.val != root.val) ? root.left.val :findSecondMinimumValue(root.left);
        int right = (root.right != null && root.right.val != root.val) ? root.right.val :findSecondMinimumValue(root.right);
        if(left == -1 || right == -1)
            return Math.max(left, right);
        return Math.min(left, right);
    }
}

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
}