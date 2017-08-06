/*
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * */

package tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {

	public static void main(String[] args) {

	}

	public static int addVal = 0;
    
    public static List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<>();
            
        List<TreeNode>[] ans = new List[n+1];
        ans[0] = new ArrayList<>();
        ans[0].add(null);
        
        TreeNode temp;
        
        int left, right;
        
        for(int i=1; i<=n; i++) {
            List<TreeNode> list = new ArrayList<>();
            for(int j=1; j<=i; j++) {
                left=j-1;
                right=i-j;
                for(TreeNode node1: ans[left]) {
                    for(TreeNode node2: ans[right]) {
                        addVal = j+1;
                        temp = new TreeNode(j);
                        temp.left = node1;
                        temp.right = inorder(node2);
                        list.add(temp);
                    }
                }
            }
            ans[i] = list;
        }
        return ans[n];
    }
    
    public static TreeNode inorder(TreeNode root) {
        if(root==null)
            return null;
        
        TreeNode node = new TreeNode(0);
        node.left = inorder(root.left);
        node.val = addVal++;
        node.right = inorder(root.right);
    
        return node;
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