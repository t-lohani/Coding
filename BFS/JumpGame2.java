/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
 * */

package bfs;

public class JumpGame2 {

	public static void main(String[] args) {
		int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
		System.out.println(jump(nums));
		
	}

	public static int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        
        int level=0;
        int currentMax=0;
        int nextMax=0;
        int i=0;
        
        while(i < currentMax+1) {
            level++;
            while(i <= currentMax) {
                if (nextMax < nums[i]+i) {
                    nextMax = nums[i]+i;
                }

                if(nextMax >= nums.length-1) {
                    return level;
                }
                i++;
            }
            currentMax = nextMax;
        }
        return 0;
    }
}
