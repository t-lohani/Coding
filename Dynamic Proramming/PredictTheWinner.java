package dynamicprogramming;

import java.util.Arrays;

public class PredictTheWinner {

	public static void main(String[] args) {
		int[] nums = {1, 5, 2};
		System.out.println(PredictTheWinner(nums));
	}

	public static boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        
        if (len%2 == 0) {
            return true;
        }
        
        int[][] dp = new int[len][len];
        for (int i=0; i<len; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int best = recurse(nums, dp, 0, len-1);
        int sum = 0;
        for (int i=0; i<len; i++) {
            sum += nums[i];
        }
        return best*2 >= sum;
    }
    
    public static int recurse(int[] nums, int[][] dp, int start, int end) {
        if (start > end) {
            return 0;
        }
        
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        
        int pickFirst = nums[start] + Math.min(recurse(nums, dp, start+2, end), recurse(nums, dp, start+1, end-1));
        int pickLast = nums[end] + Math.min(recurse(nums, dp, start+1, end-1), recurse(nums, dp, start, end-2));
        dp[start][end] = Math.max(pickFirst, pickLast);
        
        return dp[start][end];
    }
}
