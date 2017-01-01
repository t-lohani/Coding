/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 * */

package array;

public class MinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = {9, 10, 0, 1, 2, 3, 4, 5, 6};
		System.out.println(findMin(nums));
	}
	
	public static int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        
        
        if(nums[0]<nums[nums.length-1])
            return nums[0];
        
        int i=0, j=1;
        
        while(j<nums.length && nums[i]<nums[j]) {
            i++;
            j++;
        }
        return nums[i+1];
    }

}
