package stack;

import java.util.Stack;

public class BasicCalculator {

	public static void main(String[] args) {
		String s = "1+2";
		System.out.println(calculate(s));
	}

	public static int calculate(String s) {
        char[] arr = s.toCharArray();
        int sign = 1;
        int answer = 0;
        int len = arr.length;
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<len; i++) {
            if (arr[i] == '+') {
                sign = 1;
            } else if (arr[i] == '-') {
                sign = -1;
            } else if (arr[i] == '(') {
                stack.push(answer);
                stack.push(sign);
                answer = 0;
                sign = 1;
            } else if (arr[i] == ')') {
                answer = answer * stack.pop() + stack.pop();
            } else if (Character.isDigit(arr[i])) {
                int sum = arr[i]-'0';
                while (i+1 < len && Character.isDigit(arr[i+1])) {
                    sum = sum*10 + arr[i+1]-'0';
                    i++;
                }
                answer += sign*sum;
            }
        }
        
        return answer;
    }
}
