/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. 
 * */

package linkedlists;

public class PartitionList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		
		ListNode itr = partition(head, 3);
		while (itr != null) {
			System.out.print(itr.val + " ");
			itr = itr.next;
		}
	}

	public static ListNode partition(ListNode head, int x) {
        ListNode ptr = head;
        ListNode small=null, large=null;
        ListNode itrSmall = small;
        ListNode itrLarge = large;
        
        while(ptr!=null) {
            ListNode temp = new ListNode(ptr.val);
            if(ptr.val<x) {
                if(itrSmall==null) {
                    small = temp;
                    itrSmall = small;
                } else {
                    itrSmall.next = temp;
                    itrSmall = itrSmall.next;
                }
            } else {
                if(itrLarge==null) {
                    large = temp;
                    itrLarge = large;
                } else {
                    itrLarge.next = temp;
                    itrLarge = itrLarge.next;
                }
            }
            ptr = ptr.next;
        }
        
        if(small==null) {
            return large;
        } else {
            itrSmall.next = large;
            return small;
        }
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}