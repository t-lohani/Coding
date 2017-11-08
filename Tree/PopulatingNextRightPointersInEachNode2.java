package tree;

public class PopulatingNextRightPointersInEachNode2 {

	public static void main(String[] args) {

	}

	public static void connect(TreeLinkNode root) {
        TreeLinkNode curr = root;
        TreeLinkNode prev = null;
        TreeLinkNode first = null;
        
        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    if (prev != null) {
                        prev.next = curr.left;
                    } else {
                        first = curr.left;
                    }
                    prev = curr.left;
                }
                
                if (curr.right != null) {
                    if (prev != null) {
                        prev.next = curr.right;
                    } else {
                        first = curr.right;
                    }
                    prev = curr.right;
                }
                
                curr = curr.next;
            }
            
            curr = first;
            first = null;
            prev = null;
        }
    }
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}