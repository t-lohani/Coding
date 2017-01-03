/*
 * Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
 * */

package array;

public class RemoveElement {

	public static void main(String[] args) {
		int[] nums = {1,1,3,4,5,6,6,3,1,7,4,9,12,5,7,4};
		System.out.println(removeElement(nums, 1));
	}
	
	public static int removeElement(int[] nums, int val) {
        if(nums.length==0)
            return 0;
           
        int counter = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=val) {
                nums[counter] = nums[i];
                counter++;
            }
        }
        
        return counter;
    }

}
