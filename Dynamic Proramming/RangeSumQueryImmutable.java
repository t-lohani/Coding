/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * */

package dynamicprogramming;

public class RangeSumQueryImmutable {

	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		RangeSumQueryImmutable numArray = new RangeSumQueryImmutable(nums);
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
	}
	
    public int[] sumArray;

    public RangeSumQueryImmutable(int[] nums) {
        int sum = 0;
        sumArray = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            sum = sum + nums[i];
            sumArray[i] = sum;
        }   
    }

    public int sumRange(int i, int j) {
        if(i==0)
            return sumArray[j];
        else
            return sumArray[j] - sumArray[i-1];
    }
}
