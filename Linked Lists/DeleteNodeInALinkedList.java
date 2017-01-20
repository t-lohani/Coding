/*
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 * */

package linkedlists;

public class DeleteNodeInALinkedList {

	public static void main(String[] args) {

	}

	public static void deleteNode(ListNode node) {
        
        int temp = node.next.val;
        node.next.val = node.val;
        node.val = temp;
        
        node.next = node.next.next;
    }

}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}