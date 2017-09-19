package sorting;

import java.util.Arrays;

public class WiggleSort2 {

	public static void main(String[] args) {
		int[] nums = {1, 5, 1, 1, 6, 4};
		wiggleSort(nums);
		for (int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length/2];
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            } else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            } else {
                i++;
            }
        }
    }
    
    public static int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    
    public static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
