/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * */

package array;

import java.util.Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}

	public static int trap(int[] height) {
        int answer = 0;
        int head = 0, tail = height.length-1;
        int maxHeight = 0;
        
        while (head < tail) {
            if (height[head] < height[tail]) {
            	maxHeight = Math.max(maxHeight, height[head]);
            	answer += maxHeight-height[head];
            	head++;
            } else {
            	maxHeight = Math.max(maxHeight, height[tail]);
            	answer += maxHeight-height[tail];
            	tail--;
            }
        }
        
        return answer;
    }
}
