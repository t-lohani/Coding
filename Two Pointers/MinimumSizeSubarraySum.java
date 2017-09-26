package twopointers;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, nums));
	}

	public static int minSubArrayLen(int s, int[] nums) {
        int ptr1 = 0;
        int ptr2 = 0;
        int sum = 0;
        int len = nums.length;
        int answer = Integer.MAX_VALUE;
        
        while (ptr2 < len) {
            sum += nums[ptr2++];

            while (sum >= s) {
                answer = Math.min(answer, ptr2-ptr1);
                sum -= nums[ptr1++];
            }
        }
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
