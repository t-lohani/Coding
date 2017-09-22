package linkedlists;

public class ReverseNodeInKGroups {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next.next.next.next = new ListNode(10);
		
		ListNode answer = reverseKGroup(head, 3);
		
		while (answer.next != null) {
			System.out.print(answer.val + " ");
			answer = answer.next;
		}
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        int counter = k;
        while (ptr!=null && counter>0) {
            ptr = ptr.next;
            counter--;
        }
        
        if (counter == 0) {
            ListNode curr = reverseKGroup(ptr, k);
            while (k > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
                k--;
            }
            head = curr;
        } else {
            return head;
        }
        
        return head;
    }
}

/*class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}*/