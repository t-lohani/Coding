/*
 * Given a linked list, determine if it has a cycle in it.
 * */

package linkedlists;

public class LinkedListCycle {

	public static boolean hasCycle(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        
        if (head == null || head.next == null) {
            return false;
        }
        
        while (ptr2 != null && ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
            
            if (ptr1 == ptr2) {
                return true;
            }
        }
        
        return false;
    }
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
