package tree;

public class InorderSuccessorInABST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
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