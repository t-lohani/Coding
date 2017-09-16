package hashtable;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {

	public static void main(String[] args) {
		int[] nums = {3, 1, 4, 1, 5};
		System.out.println(findPairs(nums, 2));
	}

	public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    answer++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
