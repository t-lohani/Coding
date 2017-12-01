package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        
        while (i < tokens.length) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int res = helper(op1, op2, tokens[i]);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        
        return stack.pop();
    }
    
    public static int helper(int a, int b, String str) {
        int result = 0;
        switch(str) {
            case "+":
                result = a+b;
                break;
            case "-":
                result = a-b;
                break;
            case "*":
                result = a*b;
                break;
            case "/":
                result = a/b;
        }
        return result;
    }
}
