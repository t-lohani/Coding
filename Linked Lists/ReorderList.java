/*
 *  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}. 
 * */

package linkedlists;

public class ReorderList {

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
		
		reorderList(head);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	public static void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)
            return;
        
        ListNode ptrA = head;
        ListNode ptrB = head.next;
        
        while(ptrB!=null && ptrB.next!=null ) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
            ptrB = ptrB.next;
        }
        
        ptrA.next = reverse(ptrA.next);
        
        ptrB = ptrA.next;
        ptrA.next = null;
        ptrA = head;
        ListNode ptrC = ptrA.next;
        
        while(ptrB!=null) {
            ptrA.next = ptrB;
            ptrB = ptrB.next;
            ptrA.next.next = ptrC;
            ptrA = ptrC;
            if(ptrC!=null) 
                ptrC = ptrC.next;
        }
    }
    
    public static ListNode reverse(ListNode head) {
        if(head==null || head.next==null)
            return head;
            
        ListNode ptrA = null;
        ListNode ptrB = head;
        ListNode ptrC = head.next;
        
        while(ptrB.next!=null) {
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