/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * */

package array;

import java.util.Arrays;


public class RemoveDuplicatesFromSortedArray {
	
	public static void main(String[] args) {
		int[] nums = {1,1,3,4,5,6,6,3,1,7,4,9,12,5,7,4};
		Arrays.sort(nums);
		System.out.println(removeDuplicates(nums));
	}
	
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0 || nums.length==1)
            return nums.length;
            
        int head = 0;
        
        for(int i=1; i<nums.length; i++) {
            if(nums[i]!=nums[head]) {
                head++;
                nums[head] = nums[i];
            }
        }
        return head+1;
    }
}
