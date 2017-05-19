/*
 * Given a singly linked list, determine if it is a palindrome.
 * */

package linkedlists;

public class PallindromeLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
		
		System.out.println(isPalindrome(head));
	}

	public static ListNode ptr;
    
    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) {
            return true;
        }
        
        ListNode ptrA = head;
        ListNode ptrB = head.next;
        
        return recurseCheck(ptrA, ptrB);
    }
    
    public static boolean recurseCheck(ListNode slow, ListNode fast) {
        boolean isPal = true;
        if(fast!=null && fast.next!=null) {
            isPal = recurseCheck(slow.next, fast.next.next);
        }
        
        if(fast==null) {
            ptr = slow;
        } else if(fast.next==null) {
            ptr = slow.next;
        }
        
        if(slow.val==ptr.val) {
            ptr = ptr.next;
            return true && isPal;
        } else {
            return false;
        }
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}