/*
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * */

package array;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		int[] nums = {1,1,0,0,0,1,1,1};
		System.out.println(findMaxConsecutiveOnes(nums));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
        int answer = 0;
        int current = 0;
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==0 && current>0) {
                if (current > answer) {
                    answer = current;
                }
                current = 0;
            } else if (nums[i]==1) {
                current++;
            }
            
            if (i==nums.length-1 && nums[i]==1 && current > answer) {
                answer = current;
            }
        }
        
        return answer;
    }
}
