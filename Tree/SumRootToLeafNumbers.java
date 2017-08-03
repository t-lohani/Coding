/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3

The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25. 
 * */

package tree;

public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		
	}

	public static int answer = 0;
    
    public static int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
            
        findSum(root, 0);
        
        return answer;
    }
    
    public static void findSum(TreeNode node, int parentSum) {
        if(node.left==null && node.right==null) {
            answer = answer + (parentSum*10) + node.val;
            return;
        }
        
        if(node.left!=null) {
            findSum(node.left, (parentSum*10)+node.val);  
        }
        
        if(node.right!=null) {
            findSum(node.right, (parentSum*10)+node.val);
        }
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}