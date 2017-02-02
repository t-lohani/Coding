/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 * */

package dynamicprogramming;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] nums = {-3, 0, 4};
		System.out.println(maxProduct(nums));
	}

	public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        boolean streak = false;
        int answer = nums[0];
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                if (!streak) {
                    streak = true;
                    max[i] = nums[i];
                    min[i] = nums[i];
                } else {
                    max[i] = max[i-1]*nums[i] >= min[i-1]*nums[i] ? max[i-1]*nums[i]:min[i-1]*nums[i];
                    max[i] = max[i] > nums[i] ? max[i] : nums[i];
                    min[i] = max[i-1]*nums[i] <= min[i-1]*nums[i] ? max[i-1]*nums[i]:min[i-1]*nums[i];
                    min[i] = min[i] < nums[i] ? min[i] : nums[i];
                }
                if (answer < max[i]) {
                    answer = max[i];
                }
            } else if (nums[i] == 0) {
                streak = false;
                if (answer < 0) {
                    answer = 0;
                }
            }
        }
        
        return answer;
    }
}
