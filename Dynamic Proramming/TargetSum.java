package dynamicprogramming;

public class TargetSum {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		int target = 3;
		System.out.println(findTargetSumWays(nums, target));
	}

	public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum < target || (sum + target)%2 != 0) {
            return 0;
        } else {
            return subsetSum(nums, (sum + target) >>> 1);
        }
    }
    
    public static int subsetSum(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for (int i=0; i<nums.length; i++) {
            for (int j=target; j>=nums[i]; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
