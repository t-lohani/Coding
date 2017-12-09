package stack;

import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] answer = dailyTemperatures(temperatures);
		
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = len-1; i>=0; i--) {
            stack.add(i);
        }
        
        for (int i=len-1; i>=0; i--) {
            answer[i] = 0;
            
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                if (stack.peek()-i > 0)
                    answer[i] = stack.peek()-i;
            }
            
            stack.add(i);
        }
        return answer;
    }
}
