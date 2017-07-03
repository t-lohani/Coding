/*
 * Sort a linked list using insertion sort.
 * */

package linkedlists;

public class InsertionSortList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		
		ListNode itr = insertionSortList(head);
		while (itr != null) {
			System.out.print(itr.val + " ");
			itr = itr.next;
		}
	}

	public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode itr = head.next;
        
        while(itr!=null) {
            ListNode ptr = head;
            insertRecursively(itr, ptr);
            itr = itr.next;
        }
        
        return head;
    }
    
    public static void insertRecursively(ListNode end, ListNode ptr) {
        if(ptr!=end) {
            if(ptr.next!=null)
                insertRecursively(end, ptr.next);
            if(ptr.val>ptr.next.val) {
                int temp = ptr.next.val;
                ptr.next.val = ptr.val;
                ptr.val = temp;
            }
        }
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}