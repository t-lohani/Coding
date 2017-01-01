/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 * */

package array;

import java.util.Arrays;

public class MajorityElements {

	public static void main(String[] args) {
		int[] nums = {1,2,3,2,4,2,6,8,2,2,3,5,3,2,2};
		System.out.println(majorityElement(nums));
	}
	
	public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
