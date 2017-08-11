/*
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * */

package tree;

public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		
	}

	public static int minDepth = Integer.MAX_VALUE;
	public static int counter = 0;
    
    public static int minDepth(TreeNode root) {

        if(root==null)
        	return 0;
                    
        counter++;
        
        if (counter > minDepth)
            return minDepth;
            
        if(root.right==null && root.left==null) {
            if(counter<minDepth)
                minDepth = counter;
            return minDepth;
        } else {
            if(root.left!=null) {
                minDepth(root.left);
                counter--;
            }
            
            if(root.right!=null) {
                minDepth(root.right);
                counter--;
            }
        }
        
        return minDepth;
    }
}

/*class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}*/