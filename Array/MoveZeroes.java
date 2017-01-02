/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 * */

package array;

public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		moveZeroes(nums);
		
		for (int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	public static void moveZeroes(int[] nums) {
        int count = 0;
        
        for(int i=0 ; i<nums.length ; i++) {
            if(nums[i] != 0) {
                nums[count] = nums[i];
                count++;
            }
        }
        
        for(int i=count ; i<nums.length ; i++) {
            nums[i] = 0;
        }
    }

}
