package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LargestHarmoniousSubsequence {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(findLHS(nums));
	}
	
	public static int findLHS(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (long num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int answer = 0;
        for (long key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                answer = Math.max(answer, map.get(key + 1) + map.get(key));
            }
        }
        return answer;
    }
}
