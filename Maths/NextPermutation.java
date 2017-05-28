/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 * */

package maths;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int[] nums = {5,7,9,8,6,7,9,8,4,3};
		nextPermutation(nums);
		
		for (int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return;
        }
        
        int lowInd = len-2;
        
        while (lowInd>=0 && nums[lowInd] >= nums[lowInd+1]) {
            lowInd--;
        }
        
        if (lowInd < 0) {
            Arrays.sort(nums);
            return;
        }
        
        int highInd = lowInd + 1;
        
        for (int i = lowInd+1; i<len; i++) {
            if (nums[lowInd] < nums[i] && nums[i] <= nums[highInd]) {
                highInd = i;
            }
        }
        swap(lowInd, highInd, nums);
        reverse(lowInd+1, len-1, nums);
        return;
    }
    
    public static void swap (int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void reverse(int head, int tail, int[] nums) {
        while (head <= tail) {
            swap(head, tail, nums);
            head++;
            tail--;
        }
    }
}
