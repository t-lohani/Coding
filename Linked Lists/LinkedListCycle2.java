/*
 *  Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space? 
 * */

package linkedlists;

public class LinkedListCycle2 {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		ListNode temp = new ListNode(5);
		head.next.next.next.next.next = temp;
		head.next.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next.next.next.next.next = temp;
		
		ListNode itr = detectCycle(head);
		if (itr!=null) {
			System.out.println(itr.val);
		} else {
			System.out.println("No cycle");
		}
	}

	public static ListNode detectCycle(ListNode head) {
        ListNode ptrA = head;
        ListNode ptrB = head;
        
        if(head==null || head.next==null)
            return null;
        
        while(true) {
            if(ptrA.next==null)
                return null;
            
            ptrA = ptrA.next;
            
            if(ptrB.next==null || ptrB.next.next==null)
                return null;
                
            ptrB = ptrB.next.next;
            
            if(ptrA == ptrB) {
                ptrA = head;
                while(true) {
                    if(ptrA==ptrB)
                        return ptrA;
                        
                    ptrA = ptrA.next;
                    ptrB = ptrB.next;
                }
            }
        }
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}