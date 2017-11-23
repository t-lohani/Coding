package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		
		int[] ans = maxSlidingWindow(nums, k);
		
		for (int i=0; i<ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
			return new int[0];
		}
        Deque<Integer> dq = new ArrayDeque<>();
        int len = nums.length;
        int[] answer = new int[len-k+1];
        int j = 0;
        
        for (int i=0; i<len; i++) {
            if (!dq.isEmpty() && dq.peek() < i-k+1) {
                dq.poll();
            }
            
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            
            if (i >= k-1) {
                answer[j] = nums[dq.peek()];
                j++;
            }
        }
        
        return answer;
    }
}
