/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree. 
 * */

package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static void main(String[] args) {

	}

	public static int preIdx;
    public static TreeNode buildTree(int[] pre, int[] in) {
        
        if(pre.length == 0){
            return null;
        }
        Map<Integer,Integer> hm = new HashMap<>();
        for(int  i = 0 ; i < in.length ; i++){
            hm.put(in[i],i);
        }
        TreeNode root = buildRec(0,in.length-1,hm,pre);
        return root;
    }
    
    public static TreeNode buildRec(int st,int en,Map<Integer,Integer> hm, int[] pre){
        if(st<=en){
            int i = hm.get(pre[preIdx]);
        
            
            TreeNode node = new TreeNode(pre[preIdx]);
            preIdx++;
            node.left = buildRec(st,i-1,hm,pre);
            node.right = buildRec(i+1,en,hm,pre);
            return node;
        }
        return null;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}