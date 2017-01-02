/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
 * */

package array;

public class MissingNumber {

	public static void main(String[] args) {
		int[] nums = {0,1,2,3,5,6,7,8,9};
		System.out.println(missingNumber(nums));
	}

	public static int missingNumber(int[] nums) {
        
        int xorAll = 0;
        int i;
        
        for(i=0; i<nums.length; i++) {
            xorAll = xorAll^i^nums[i];
        }
        
        xorAll = xorAll^i;
        
        return xorAll;
    }
}
