/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass. 
 * */

package linkedlists;

public class RemoveNthNodeFromEndOfList {

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
		
		ListNode itr = removeNthFromEnd(head, 3);
		while (itr != null) {
			System.out.print(itr.val + " ");
			itr = itr.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptrA = head, ptrB = head;
        
        while(n>0) {
            ptrB = ptrB.next;
            n--;
        }
        
        if(ptrB==null)
            return head.next;
            
        while(ptrB.next!=null) {
            ptrB = ptrB.next;
            ptrA = ptrA.next;
        }
        
        ptrA.next = ptrA.next.next;
        return head;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}