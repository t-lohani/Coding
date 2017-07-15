/*
 * Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.

It can have between 1 and 2h nodes inclusive at the last level h.
 * */

package tree;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {

	}

	public static int countNodes(TreeNode root) {
    	if (root==null) return 0;
    	if (root.left==null) return 1;
    	int height = 0;
        int nodesSum = 0;
    	TreeNode curr = root;
        while(curr.left!=null) {
        	nodesSum += (1<<height);
        	height++;
        	curr = curr.left;
        }
        return nodesSum + countLastLevel(root, height);
    }
    
    private static int countLastLevel(TreeNode root, int height) {
    	if(height==1) 
    		if (root.right!=null) return 2;
    		else if (root.left!=null) return 1;
    		else return 0;
    	TreeNode midNode = root.left;
    	int currHeight = 1;
    	while(currHeight<height) {
    		currHeight++;
    		midNode = midNode.right;
    	}
    	if (midNode==null) return countLastLevel(root.left, height-1);
    	else return (1<<(height-1)) + countLastLevel(root.right, height-1);
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}