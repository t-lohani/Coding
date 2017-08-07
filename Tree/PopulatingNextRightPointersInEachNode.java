/*
 *  Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

 * */

package tree;

public class PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {

	}
	
	public static void connect(TreeLinkNode root) {
        if(root==null)
            return;
            
        root.next = null;
        traverseAndConnect(root, null);
    }
    
    public static void traverseAndConnect(TreeLinkNode node, TreeLinkNode parent) {
        if(node.left==null || node.right==null)
            return;
            
        node.left.next = node.right;
        if(parent!=null)
            node.right.next = parent.left;
        else
            node.right.next = null;
            
        traverseAndConnect(node.left, node.left.next);
        traverseAndConnect(node.right, node.right.next);
    }

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}