/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * */

package tree;

public class ConvertedSortedArrayToBinarySearchTree {

	public static void main(String[] args) {

	}

	public static TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums.length==0)
            return null;
        
        return makeBST(0, nums.length-1, nums);
    }
    
    public static TreeNode makeBST(int start, int end, int[] numArr) {
        
        int middle = (start+end)/2;
        
        TreeNode temp = new TreeNode(numArr[middle]);
        
        if(middle-1>=start)
            temp.left = makeBST(start, middle-1, numArr);
        else
            temp.left = null;
            
        if(middle+1<=end)
            temp.right = makeBST(middle+1, end, numArr);
        else
            temp.right = null;
        
        return temp;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}