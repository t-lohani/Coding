/*
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * */

package maths;

public class MinimumMovesToEqualArrayElements {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		System.out.println(minMoves(nums));
	}
	
	public static int minMoves(int[] nums) {
        
        int sum = 0;
        int min = nums[0];
        
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        
        return sum - (nums.length*min);
    }

}
