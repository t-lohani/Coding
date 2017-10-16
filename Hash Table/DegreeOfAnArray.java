package hashtable;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

	public static void main(String[] args) {
		int[] nums = {1,2,2,3,1,4,2};
		System.out.println(findShortestSubArray(nums));
	}

	public static int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int answer = Integer.MAX_VALUE;
        int maxFreq = 0;
        
        if (nums.length == 0) {
            return 0;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] value = map.get(nums[i]);
                value[0]++;
                value[2] = i;
                map.put(nums[i], value);
            } else {
                int[] value = {1, i, i};
                map.put(nums[i], value);
            }
        }
        
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (entry.getValue()[0] >= maxFreq) {
                if (entry.getValue()[0] == maxFreq) {
                    int diff = entry.getValue()[2]-entry.getValue()[1]+1;
                    answer = Math.min(answer, diff);
                } else {
                    maxFreq = entry.getValue()[0];
                    answer = entry.getValue()[2]-entry.getValue()[1]+1;
                }
            }
        }
        
        return answer;
    }
}
