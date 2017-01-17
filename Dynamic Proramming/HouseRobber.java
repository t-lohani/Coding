/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * */

package dynamicprogramming;

public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = {3, 8, 6, 9, 2, 7, 5, 7, 2, 9, 7, 6};
		System.out.println(rob(nums));
	}
	
	public static int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
    
        int[] maxAmount = new int[nums.length];
        maxAmount[0] = nums[0];
        maxAmount[1] = nums[1];
        int Answer = nums[0] > nums[1] ? nums[0] : nums[1];
        
        for(int i=2 ; i<nums.length ; i++) {
            int maxSum = 0;
            for(int j=i-2; j>=0; j--) {
                if(maxSum < maxAmount[j] + nums[i]) {
                    maxSum = maxAmount[j] + nums[i];
                }
            }
            maxAmount[i] = maxSum;
            if(Answer < maxSum)
                Answer = maxSum;
        }
        return Answer;
    }
}
