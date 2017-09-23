package array;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	public static void main(String[] args) {
		int[] nums = {0,1};
		System.out.println(findMaxLength(nums));
	}

	public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
            sum += nums[i];
            if (map.containsKey(sum)) {
                max = Math.max(max, i-map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        
        return max;
    }
}
