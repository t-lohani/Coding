/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * */

package tree;

public class ConvertSortedListToBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next.next = new ListNode(9);
		
		TreeNode node = sortedListToBST(head);
		inOrder(node);
	}

	public static ListNode node;
    
    public static TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
            
        int length = 0;
        ListNode ptr = head;
        node = head;
        
        while(ptr!=null) {
            length++;
            ptr = ptr.next;
        }
        
        return createBST(0, length-1);
    }
    
    public static TreeNode createBST(int start, int end) {
        if(start > end)
            return null;
            
        int mid = (start+end)/2;
        
        TreeNode left = createBST(start, mid - 1);
		TreeNode root = new TreeNode(node.val);
		node = node.next;
		TreeNode right = createBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
    }
    
    public static void inOrder(TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	
    	inOrder(node.left);
    	System.out.print(node.val + " ");
    	inOrder(node.right);
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}