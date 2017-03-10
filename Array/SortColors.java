/*
 *  Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem. 
 * */

package array;

public class SortColors {

	public static void main(String[] args) {
		int[] nums = {0,1,1,2,1,0,0,2,1,2,1,1,0,2,0};
		sortColors(nums);
		
		for (int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	public static void sortColors(int[] nums) {
        int i=0, j=0, k=nums.length-1;
        
        while(j<=k) {
            
            if(nums[j]==0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                i++;
                j++;
            }
            
            if(j<=k && nums[j]==1) {
                j++;
            }
            
            if(j<=k && nums[j]==2) {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                
                k--;
            }
        }
    }

}
