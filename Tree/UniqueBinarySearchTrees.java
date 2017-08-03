/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * */

package tree;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(numTrees(n));
	}

	public static int numTrees(int n) {
        int[] arr = new int[n+1];
        arr[0]=1;
        
        int left, right;
        
        for(int i=1; i<=n; i++) {
            int num = 0;
            for(int j=1; j<=i; j++) {
                left=j-1;
                right=i-j;
                num = num + (arr[left]*arr[right]);
            }
            arr[i] = num;
        }
        
        return arr[arr.length-1];
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