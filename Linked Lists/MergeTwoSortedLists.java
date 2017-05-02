/*
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * */

package linkedlists;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode headA = new ListNode(0);
		headA.next = new ListNode(1);
		headA.next.next = new ListNode(2);
		headA.next.next.next = new ListNode(7);
		headA.next.next.next.next = new ListNode(10);
		headA.next.next.next.next.next = new ListNode(15);
	
		ListNode headB = new ListNode(0);
		headB.next = new ListNode(4);
		headB.next.next = new ListNode(8);
		headB.next.next.next = new ListNode(10);
		headB.next.next.next.next = new ListNode(12);
		headB.next.next.next.next.next = new ListNode(18);
		
		ListNode itr = mergeTwoLists(headA, headB);
		while (itr != null) {
			System.out.print(itr.val + " ");
			itr = itr.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged, counter;
        
        if(l1==null && l2==null)
            return null;
        
        if(l1==null)
            return l2;
        
        if(l2==null)
            return l1;
            
        if(l1.val <= l2.val) {
            merged = l1;
            l1 = l1.next;
        } else {
            merged = l2;
            l2 = l2.next;
        }
        counter = merged;
        
        while(l1!=null && l2!=null) {
            if(l1.val <= l2.val) {
                counter.next = l1;
                l1 = l1.next;
            } else {
                counter.next = l2;
                l2 = l2.next;
            }
            counter = counter.next;
        }
        
        if(l1!=null) {
            counter.next = l1;
        } else if(l2!=null) {
            counter.next = l2;
        }
        
        return merged;
    }
}

/*class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}*/