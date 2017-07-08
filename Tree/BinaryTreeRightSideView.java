/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * */

package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		
	}

	public static List<Integer> list = new ArrayList<Integer>();
	public static int maxCount = 0;
    
    public static List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return list;
            
        rightTraverse(root, 1);
        
        return list;
    }
    
    public static void rightTraverse(TreeNode node, int count) {
        if(node==null)
            return;
            
        if(count>maxCount) {
            list.add(node.val);
            maxCount = count;
        }
        
        rightTraverse(node.right, count+1);
        rightTraverse(node.left, count+1);
    }
}
