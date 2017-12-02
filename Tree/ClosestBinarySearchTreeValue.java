package tree;

public class ClosesBinarySearchTreeValue {

	public static void main(String[] args) {

	}

	static int less;
	static int more;
    
    public static int closestValue(TreeNode root, double target) {
        less = root.val;
        more = root.val;
        search(root, target);
        
        if (Math.abs(less-target) > Math.abs(more-target)) {
            return more;
        } else {
            return less;
        }
    }
    
    public static void search(TreeNode node, double target) {
        if (node == null) {
            return;
        }
        
        if (node.val == target) {
            less = node.val;
            more = node.val;
        } else if (node.val > target) {
            more = node.val;
            search(node.left, target);
        } else if (node.val < target) {
            less = node.val;
            search(node.right, target);
        }
    }
}
