package stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int[] heights = {2,1,2};
		System.out.println(largestRectangleArea(heights));
	}

	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
        int len = heights.length;
        
        int answer = 0;
        int left = 0;
        int right;
        
        while (left<len) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[left]) {
                stack.push(left++);
            } else {
                right = stack.pop();
                int height = heights[right];
                answer = Math.max(answer, height*(stack.empty() ? left : left - stack.peek() - 1));
            }
        }
        
        while (!stack.isEmpty()) {
            right = stack.pop();
            int height = heights[right];
            answer = Math.max(answer, height*(stack.empty() ? left : left - stack.peek() - 1));
        }
        
        return answer;
    }
}
