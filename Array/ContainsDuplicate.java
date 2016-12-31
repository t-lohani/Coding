/*
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * */

package array;

import java.util.Arrays;

public class ContainsDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,1,3,4,5,6,6,3,1,7,4,9,12,5,7,4};
		System.out.println(containsDuplicate(nums));
	}
	
	public static boolean containsDuplicate(int[] nums) {
        
        if(nums.length == 0 || nums.length == 1)
            return false;
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

}
