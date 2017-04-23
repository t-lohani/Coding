/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

 * */

package linkedlists;

public class IntersetionOfTwoLinkedLists {

	public static void main(String[] args) {
		ListNode headA = new ListNode(0);
		headA.next = new ListNode(1);
		headA.next.next = new ListNode(2);
		headA.next.next.next = new ListNode(3);
		headA.next.next.next.next = new ListNode(4);
		ListNode temp = new ListNode(5);
		headA.next.next.next.next.next = temp;
		headA.next.next.next.next.next.next = new ListNode(6);
		headA.next.next.next.next.next.next.next = new ListNode(7);
		headA.next.next.next.next.next.next.next.next = new ListNode(8);
		headA.next.next.next.next.next.next.next.next.next = new ListNode(9);
		
		ListNode headB = new ListNode(0);
		headB.next = new ListNode(1);
		headB.next.next = new ListNode(2);
		headB.next.next.next = new ListNode(3);
		headB.next.next.next.next = new ListNode(4);
		headB.next.next.next.next.next = temp;
		
		System.out.println(getIntersectionNode(headA, headB).val);
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        while(headA!=null) {
            lengthA++;
            headA = headA.next;
        }
        
        while(headB!=null) {
            lengthB++;
            headB = headB.next;
        }
        
        if(lengthA>lengthB) {
            int counter = lengthA-lengthB;
            while(counter>0) {
                ptrA = ptrA.next;
                counter--;
            }
        } else if(lengthB>lengthA){
            int counter = lengthB-lengthA;
            while(counter>0) {
                ptrB = ptrB.next;
                counter--;
            }
        }
        
        while(ptrA!=null) {
            if(ptrA==ptrB)
                return ptrA;
                
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        
        return ptrA;
    }
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}