/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum. 
 * */

package tree;

public class PathSum {

	public static void main(String[] args) {
		
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
        if(root!=null) {
            sum = sum - root.val;

            if(sum==0 && root.right==null && root.left==null) {
                return true;
            } else {
                return false || hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
            }
        }
        
        return false;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}