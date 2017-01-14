/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * */

package bitmanipulation;

public class SingleNumber {

	public static void main(String[] args) {
		int[] nums = {1,2,2,3,3,4,4};
		System.out.println(singleNumber(nums));
	}
	
	public static int singleNumber(int[] nums) {
        int xor = 0;
        
        for (int i=0; i<nums.length; i++) {
            xor ^= nums[i];
        }
        
        return xor;
    }

}
