/*
 * Reverse a singly linked list.
 * */

package linkedlists;

public class ReverseLinkedList {

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
		
		ListNode itr = reverseList(head);
		while (itr != null) {
			System.out.print(itr.val + " ");
			itr = itr.next;
		}
	}

	public static ListNode reverseList(ListNode head) {
        
        if(head == null)
            return null;
        
        if(head.next == null)
            return head;
        
        ListNode ptrA = null;
        ListNode ptrB = head;
        ListNode ptrC = head.next;
        
        while(ptrB.next != null) {
            ptrB.next = ptrA;
            ptrA = ptrB;
            ptrB = ptrC;
            ptrC = ptrC.next;
        }
        
        ptrB.next = ptrA;
        return ptrB;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}