/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * */

package tree;

public class KthSmallestElementInABST {

	public static void main(String[] args) {
		
	}

	public static int kVal=0, answer=0;
    
    public static int kthSmallest(TreeNode root, int k) {
        kVal = k;
        inOrder(root);
        return answer;
    }
    
    public static void inOrder(TreeNode node) {
        if(node==null)
            return;
        
        if(kVal>0) {
            inOrder(node.left);
            kVal--;
            if(kVal==0)
                answer = node.val;
            inOrder(node.right);
        }
    }
}
