/*
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * */

package stack;

import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {
		String num = "1234567890";
		int k = 3;
		
		System.out.println(removeKdigits(num, k));
	}

	public static String removeKdigits(String num, int k) {
		if (num.length() <= k) {
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        char[] chArr = num.toCharArray();
        
        for (int i=0; i<chArr.length; i++) {
            while (!stack.isEmpty() && stack.peek() > chArr[i] && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(chArr[i]);
        }
        
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder str = new StringBuilder();        
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        
        while (str.length() != 0 && str.charAt(str.length()-1) == '0') {
            str.deleteCharAt(str.length()-1);
        }
        
        if (str.length() == 0) {
            return "0";
        }
        
        str.reverse();
        return str.toString();
    }
}
