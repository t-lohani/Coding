package stack;

import java.util.Stack;

public class BaseballGame {

	public static void main(String[] args) {
		String[] ops = {"5","2","C","D","+"};
		System.out.println(calPoints(ops));
	}

	public static int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();

        for(int i=0; i<ops.length; i++) {
            if (ops[i].equals("+")) {
                int top = stack.pop();
                int sum = top + stack.peek();
                stack.push(top);
                stack.push(sum);
            } else if (ops[i].equals("D")) {
                stack.push(2*stack.peek());
            } else if (ops[i].equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(ops[i]));
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
        	answer += stack.pop();
        }
        return answer;
    }
}
