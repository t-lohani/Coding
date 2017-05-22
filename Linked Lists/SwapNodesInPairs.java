/*
 *  Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
 * */

package linkedlists;

public class SwapNodesInPairs {

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
		
		ListNode itr = swapPairs(head);
		while (itr != null) {
			System.out.print(itr.val + " ");
			itr = itr.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        p2.next = p1;
        p1.next = swapPairs(p3);
        return p2;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}