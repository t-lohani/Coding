/*
 *  Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3. 
 * */

package linkedlists;

public class RemoveDuplicatesFromSortedList2 {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next.next.next.next = new ListNode(9);
		
		ListNode itr = deleteDuplicates(head);
		while (itr != null) {
			System.out.print(itr.val + " ");
			itr = itr.next;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) {
            return null;
        }
        
        if(head.next!=null && head.val==head.next.val) {
            while(head.next!=null && head.val==head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        
        return head;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}