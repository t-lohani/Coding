/*
 *  Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.  
 * */

package linkedlists;

public class ReverseLinkedList2 {

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
		
		ListNode itr = reverseBetween(head, 3, 7);
		while (itr != null) {
			System.out.print(itr.val + " ");
			itr = itr.next;
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(head==null || head.next==null)
            return head;
            
        int count  =1;
        ListNode startPrev = null;
        ListNode start = head;
        
        while(count<m) {
            startPrev = start;
            start = start.next;
            count++;
        }
        
        ListNode end = start;
        ListNode endNext = start.next;
        
        while(count<n) {
            end = end.next;
            endNext = endNext.next;
            count++;
        }
        
        reverseList(start, end);
        
        if(startPrev==null)
            head = end;
        else
            startPrev.next = end;
        
        start.next = endNext;
        
        return head;
    }
    
    public static void reverseList(ListNode start, ListNode end) {
        ListNode ptrA = null;
        ListNode ptrB = start;
        ListNode ptrC = start.next;
        
        while(ptrA!=end) {
            ptrB.next = ptrA;
            ptrA = ptrB;
            ptrB = ptrC;
            if(ptrC!=null)
                ptrC = ptrC.next;
        }
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}