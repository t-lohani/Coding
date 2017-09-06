package tree;

public class CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return 0;
        
        return  postOrder(root).count;
    }
    
    public static TreeInfo postOrder(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new TreeInfo(node.val, 1, true);
        }
        
        TreeInfo left = null;
        TreeInfo right = null;
        TreeInfo child = null;
        
        if (node.left == null || node.right == null) {
            if (node.left == null)
                child = postOrder(node.right);
            else if (node.right == null)
                child = postOrder(node.left);
            
            if (child.isUniValue && node.val == child.univalue) {
                return new TreeInfo(node.val, child.count+1, true);
            } else {
                return new TreeInfo(node.val, child.count, false);
            }
        }
        
        left = postOrder(node.left);
        right = postOrder(node.right);
        
        if (left.isUniValue && right.isUniValue && left.univalue == right.univalue && left.univalue == node.val) {
            return new TreeInfo(node.val, left.count+right.count+1, true);
        } else {
            return new TreeInfo(node.val, left.count+right.count, false);
        }
    }
}

class TreeInfo {
    int univalue;
    int count;
    boolean isUniValue;
    
    public TreeInfo(int uv, int c, boolean isUniv) {
        univalue = uv;
        count = c;
        isUniValue = isUniv;
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