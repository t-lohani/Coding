/*
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).
 * */

package array;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] answer = productExceptSelf(nums);
		
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] answer = new int[nums.length];
        
        left[0] = 1;
        right[nums.length-1] = 1;
        
        for(int i=1, j=nums.length-2; i<nums.length && j>=0; i++, j--) {
            left[i] = nums[i-1]*left[i-1];
            right[j] = nums[j+1]*right[j+1];
        }
        
        for(int i=0; i<nums.length; i++)
            answer[i] = left[i]*right[i];
            
            return answer;
    }

}
