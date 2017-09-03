package tree;

public class ConstructStringFromBinaryTree {

	public static String tree2str(TreeNode node) {
        if (node == null) {
            return "";
        }
        
        String answer = preOrder(node);
        return answer.substring(1, answer.length()-1);
    }
    
    public static String preOrder(TreeNode node) {
        if (node == null)
            return "";
        
        if (node.left == null && node.right == null) {
            return "(" + node.val + ")";
        } else if (node.left == null) {
            return "(" + node.val + "()" + preOrder(node.right) + ")";
        } else if (node.right == null) {
            return "(" + node.val + preOrder(node.left) + ")";
        } else {
            return "(" + node.val + preOrder(node.left) + preOrder(node.right) + ")";
        }
    }

}

class TreeNode {
	int val;
	public TreeNode left;
	public TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
