/*
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. 
 * */

package linkedlists;

public class RemoveDuplicatesFromSortedList {

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
        if(head==null)
            return null;
            
        ListNode point = head;
        while(point.next!=null) {
            if(point.val == point.next.val) {
                point.next = point.next.next;
            } else {
                point = point.next;
            }
        }
    
        return head;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}