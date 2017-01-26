/*
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * */

package bitmanipulation;

public class SingleNumber3 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] answer = singleNumber(nums);
		
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	public static int[] singleNumber(int[] nums) {
        int xor = 0;
        int newXor = 0;
        int[] answer = new int[2];
        
        for (int i=0; i<nums.length; i++) {
            xor ^= nums[i];
        }
        
        int mask = 0;
        
        for (int i=0; i<32; i++) {
            mask = 1<<i;
            if ((xor & mask) == mask) {
                break;
            }
        }
        
        for (int i=0; i<nums.length; i++) {
            if ((nums[i] & mask) == mask) {
                newXor ^= nums[i];
            }
        }
        
        answer[0] = newXor;
        answer[1] = xor^newXor;
        
        return answer;
    }

}
