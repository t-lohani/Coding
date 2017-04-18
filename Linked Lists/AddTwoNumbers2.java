/*
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * */

package linkedlists;

public class AddTwoNumbers2 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode answer = addTwoNumbers(l1, l2);
		
		while (answer!=null) {
			System.out.print(answer.val + " ");
			answer = answer.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        while (l1!=null) {
            str1.append(l1.val+"");
            l1 = l1.next;
        }
        
        while (l2!=null) {
            str2.append(l2.val+"");
            l2 = l2.next;
        }
        
        String num1 = str1.toString();
        String num2 = str2.toString();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        
        ListNode ln = new ListNode(Character.getNumericValue(sb.charAt(sb.length()-1)));
        ListNode answer = ln;

        for (int i=sb.length()-2; i>=0; i--) {
            ListNode temp = new ListNode(Character.getNumericValue(sb.charAt(i)));
            ln.next = temp;
            ln = ln.next;            
        }
        
        return answer;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}