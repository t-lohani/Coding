/*
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ... 
 * */

package linkedlists;

public class OddEvenLinkedList {

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
		
		ListNode itr = oddEvenList(head);
		while (itr != null) {
			System.out.print(itr.val + " ");
			itr = itr.next;
		}
	}
	
	public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)
            return head;
            
        ListNode ptrA = head;
        ListNode ptrB = head.next;
        ListNode head2 = head.next;
        
        while(ptrA.next!=null && ptrB.next!=null) {
            ptrA.next = ptrB.next;
            ptrA = ptrA.next;
            ptrB.next = ptrA.next;
            ptrB = ptrB.next;
        }
        
        ptrA.next = head2;
        
        return head;
    }
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}