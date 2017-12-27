package dynamicprogramming;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = {3,5,8,2,4,7,9,0,3,5,2,7,9,6,8,4,8};
		System.out.println(lengthOfLIS(nums));
	}

	public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int count[] = new int[len];
        int answer = 0;
        
        for (int i=0; i<len; i++) {
            count[i] = 1;
            for (int j = i-1; j>=0; j--) {
                if (nums[j] < nums[i] && count[j]+1>count[i]) {
                    count[i] = count[j]+1;
                }
            }
            
            answer = Math.max(answer, count[i]);
        }
        
        return answer;
    }
}
