package dynamicprogramming;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		int[] nums = {1,5,5,11};
		System.out.println(canPartition(nums));
	}

	public static boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return true;
        } else if (nums.length == 1) {
            return false;
        }
        
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1)
            return false;

        sum = sum/2;
        
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        
        for (int i=0; i<nums.length+1; i++) {
            dp[i][0] = true;
        }
        
        for (int i=0; i<sum+1; i++) {
            dp[0][i] = false;
        }
        
        dp[0][0] = true;
        
        for (int i=1; i<nums.length+1; i++) {
            for (int j=1; j<sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        
        return dp[nums.length][sum];
    }
}
