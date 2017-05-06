/*
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5 
 * */

package linkedlists;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next.next = new ListNode(3);
		
		ListNode itr = removeElements(head, 3);
		while (itr != null) {
			System.out.print(itr.val + " ");
			itr = itr.next;
		}
	}
	
	public static ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
            
        while(head!=null && head.val==val)
            head = head.next;
            
        ListNode count = head;
        
        while(count!=null && count.next!=null) {
            if(count.next.val==val) {
                count.next = count.next.next;
            } else {
                count = count.next;
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