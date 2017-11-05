package stack;

import java.util.Stack;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		String s = "(()))((()()())()()()()((((()()()))()()(";
		System.out.println(longestValidParentheses(s));
	}

	public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int answer = 0;
        int i = 0;
        
        while (i < arr.length) {
            if (arr[i] == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    if (arr[stack.peek()] == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
            i++;
        }
        
        if (stack.isEmpty()) {
            return arr.length;
        }
        
        int ptr1 = arr.length;
        int ptr2 = 0;
        while (!stack.isEmpty()) {
            ptr2 = stack.pop();
            answer = Math.max(answer, ptr1-ptr2-1);
            ptr1 = ptr2;
        }
        answer = Math.max(answer, ptr1);
        return answer;
    }
}
