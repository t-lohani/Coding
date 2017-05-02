/*
 *  A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list. 
 * */

package linkedlists;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(0);
		head.next = new RandomListNode(1);
		head.next.next = new RandomListNode(2);
		head.next.next.next = new RandomListNode(3);
		head.next.next.next.next = new RandomListNode(4);
		head.next.next.next.next.next = new RandomListNode(5);
		head.next.next.next.next.next.next = new RandomListNode(6);
		head.next.next.next.next.next.next.next = new RandomListNode(7);
		head.next.next.next.next.next.next.next.next = new RandomListNode(8);
		head.next.next.next.next.next.next.next.next.next = new RandomListNode(9);
		
		RandomListNode itr = copyRandomList(head);
		while (itr != null) {
			System.out.print(itr.label + " ");
			itr = itr.next;
		}
	}

	public static RandomListNode copyRandomList(RandomListNode head) {
        
        if(head==null) {
            return null;
        }
        
        RandomListNode ptr = head;
        RandomListNode temp;
        RandomListNode headNew;
        
        while(ptr!=null) {
            RandomListNode newNode = new RandomListNode(ptr.label);
            temp = ptr.next;
            ptr.next = newNode;
            newNode.next = temp;
            ptr = ptr.next.next;
        }
        
        ptr = head;
        
        while(ptr!=null) {
            if(ptr.random!=null) {
                ptr.next.random = ptr.random.next;
            }

            ptr = ptr.next.next;
        }
        
        ptr = head;
        headNew = head.next;
        temp = headNew;
        
        while(temp.next!=null) {
            ptr.next = temp.next;
            temp.next = ptr.next.next;
            ptr = ptr.next;
            temp = temp.next;
        }
        
        ptr.next = null;
        return headNew;
    }
}

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};