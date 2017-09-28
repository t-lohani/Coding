package hashtable;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		int k = 15;
		System.out.println(maxSubArrayLen(nums, k));
	}

	public static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int answer = 0;
        
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            
            if (map.containsKey(sum - k)) {
                answer = Math.max(answer, i - map.get(sum - k));
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return answer;
    }
}
