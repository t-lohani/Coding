package stack;

import java.util.Stack;

public class MaximalRectangle {

	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},
						   {'1','0','1','1','1'},
						   {'1','1','1','1','1'},
						   {'1','0','0','1','0'}};
		
		System.out.println(maximalRectangle(matrix));
	}

	public static int maximalRectangle(char[][] matrix) {
        int len = matrix.length;
        if (len == 0) {
            return 0;
        }
        int wid = matrix[0].length;
        int[] heights = new int[wid];
        int answer = 0;
        
        for (int i=0; i<len; i++) {
            for (int j=0; j<wid; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            answer = Math.max(answer, largestRectangleArea(heights));
        }
        
        return answer;
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
