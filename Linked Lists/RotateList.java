/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 * */

package linkedlists;

public class RotateList {

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
		
		ListNode itr = rotateRight(head, 5);
		while (itr != null) {
			System.out.print(itr.val + " ");
			itr = itr.next;
		}
	}

	public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
            
        int count = 0;
        ListNode ptr = head;
        
        while(ptr!=null) {
            ptr = ptr.next;
            count++;
        }
        
        k=k%count;
        if(k==0)
            return head;
            
        int index = 0;
        
        ListNode prev = null;
        ptr = head;
        
        while(index<(count-k)) {
            prev = ptr;
            ptr = ptr.next;
            index++;
        }
        
        prev.next = null;
        ListNode newHead = ptr;
        index = 1;
        
        while(index<k) {
            ptr = ptr.next;
            index++;
        }
        
        ptr.next = head;
        
        return newHead;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}