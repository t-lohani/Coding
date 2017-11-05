package sorting;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		int target = 1;
		System.out.println(threeSumClosest(nums, target));
	}

	public static int threeSumClosest(int[] nums, int target) {
        int answer = nums[0] + nums[1] + nums[2];
        int sum = 0;
        int len = nums.length;
        Arrays.sort(nums);
        
        for (int i=0; i<len-2; i++) {
            int j = i+1;
            int k = len-1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target-answer) > Math.abs(target - sum)) {
                    answer = sum;
                    if (answer == target) return answer;
                }
                
                if (sum > target)
                    k--;
                else
                    j++;
            }
        }
        
        return answer;
    }
}
