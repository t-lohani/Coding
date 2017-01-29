/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * */

package linkedlists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode listA = new ListNode(1);
		listA.next = new ListNode(2);
		listA.next.next = new ListNode(3);
		listA.next.next.next = new ListNode(4);
		listA.next.next.next.next = new ListNode(5);
		
		ListNode listB = new ListNode(3);
		listB.next = new ListNode(4);
		listB.next.next = new ListNode(5);
		listB.next.next.next = new ListNode(6);
		listB.next.next.next.next = new ListNode(7);
		
		ListNode listC = new ListNode(7);
		listC.next = new ListNode(8);
		listC.next.next = new ListNode(9);
		listC.next.next.next = new ListNode(10);
		
		ListNode[] lists = new ListNode[3];
		lists[0] = listA;
		lists[1] = listB;
		lists[2] = listC;
		
		ListNode ans = mergeKLists(lists);
		
		while (ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
        ListNode answer = null;
        ListNode itr = null;
        int k = lists.length;
        if (k == 0) {
            return answer;
        }
        ListNodeComparator comp = new ListNodeComparator();
        PriorityQueue<ListNode> pQ = new PriorityQueue<>(k, comp);
        
        for (int i=0; i<k; i++) {
            if (lists[i] != null) {
                pQ.add(lists[i]);
            }
        }
        
        if (!pQ.isEmpty()) {
            answer = pQ.remove();
            itr = answer;
            if (answer.next != null) {
                pQ.add(answer.next);
            }
        }
        
        while (!pQ.isEmpty()) {
        	ListNode temp = pQ.remove();
            itr.next = temp;
            if (temp.next != null) {
                pQ.add(temp.next);
            }
            itr = itr.next;
        }
        
        return answer;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class ListNodeComparator implements Comparator<ListNode>
{
    public int compare(ListNode x, ListNode y)
    {
        return x.val - y.val;
    }
}