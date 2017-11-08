package tree;

public class RecoverBinarySearchTree {

	public static void main(String[] args) {

	}
	
	static TreeNode firstElement = null;
	static TreeNode secondElement = null;
	static TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    
    public static void recoverTree(TreeNode root) {
        
        traverse(root);
        
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    private static void traverse(TreeNode root) {
        
        if (root == null)
            return;
            
        traverse(root.left);
        
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
    
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }        
        prevElement = root;

        traverse(root.right);
    }
}
