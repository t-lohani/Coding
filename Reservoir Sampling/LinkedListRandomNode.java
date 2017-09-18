package reservoirsampling;

import java.util.Random;

public class LinkedListRandomNode {

	public static void main(String[] args) {
		ListNode start = new ListNode(1);
		start.next = new ListNode(2);
		start.next.next = new ListNode(3);
		
		LinkedListRandomNode lrn = new LinkedListRandomNode(start);
		System.out.println(lrn.getRandom());
	}

	private ListNode head;
    private Random rand;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int k = 1;
        ListNode node = this.head;
        int res = node.val;
        int i = 0;
        int[] reservoir = new int[k];
        
        while (i < k && node != null) {
            reservoir[i] = node.val;
            node = node.next;
            i++;
        }
        
        i++;
        while (node != null) {
            if (rand.nextInt(i) < k) {
                reservoir[rand.nextInt(k)] = node.val;
            }
            i++;
            node = node.next;
        }
        return reservoir[0];
    }
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
