/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * */

package array;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	
	public static int maxSubArray(int[] nums) {
        
        int currentMax = nums[0];
        int[] sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            sumArray[i] = nums[i]>nums[i]+sumArray[i-1]?nums[i]:nums[i]+sumArray[i-1];
            currentMax = currentMax>sumArray[i]?currentMax:sumArray[i];
        }
        
        return currentMax;
    }

}
