/*
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 * */

package tree;

public class DeleteNodeInABST {

	public static void main(String[] args) {

	}

	public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode succ = findSuccessor(root.right);
                if (succ == root.right) {
                    succ.left = root.left;
                    return succ;
                } else {
                    succ.right = root.right;
                    succ.left = root.left;
                    return succ;
                }
            }
        }

        preOrder(root, null, key);
        return root;
    }
    
    public static void preOrder(TreeNode node, TreeNode parent, int key) {
        if (node == null) {
            return;
        }
        
        if (node.val == key) {
            if (node.left == null) {
                if (parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            } else if (node.right == null) {
                if (parent.left == node) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            } else {
                TreeNode succ = findSuccessor(node.right);
                if (succ == node.right) {
                    succ.left = node.left;
                    node.left = null;
                    if (parent.left == node) {
                        parent.left = succ;
                    } else {
                        parent.right = succ;
                    }
                } else {
                    succ.right = node.right;
                    succ.left = node.left;
                    if (parent.left == node) {
                        parent.left = succ;
                    } else {
                        parent.right = succ;
                    }
                }
            }
        } else if (node.val > key) {
            preOrder(node.left, node, key);
        } else {
            preOrder(node.right, node, key);
        }
    }
    
    public static TreeNode findSuccessor(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        
        TreeNode parent = node;
        node = node.left;
        
        while (node.left!=null) {
            parent = node;
            node = node.left;
        }
        
        parent.left = node.right;
        return node;
    }
}
