/*
 * 
 * */

package design;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeIterator {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		BSTIterator i = new BSTIterator(root);
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

}

class BSTIterator {

    Queue<Integer> queue = new LinkedList<>();
    
    public BSTIterator(TreeNode root) {
        doInorder(root);
    }
    
    public void doInorder(TreeNode node) {
        if (node == null)
            return;
            
        doInorder(node.left);
        queue.add(node.val);
        doInorder(node.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return queue.remove();
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}