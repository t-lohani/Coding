package array;

public class LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums  = {1,3,5,7};
		System.out.println(findLengthOfLCIS(nums));
	}
	
	public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        boolean streak = false;
        int answer = 1;
        int count = 1;
        
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                count++;
            } else {
                answer = Math.max(answer, count);
                count = 1;
            }
        }
        
        answer = Math.max(count, answer);
        return answer;
    }

}
