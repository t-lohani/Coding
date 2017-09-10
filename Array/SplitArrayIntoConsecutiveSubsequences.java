package array;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		System.out.println(isPossible(nums));
	}

	public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> canStart = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }
        
        for (int i=0; i<nums.length; i++) {
            if (count.get(nums[i]) == 0) {
                continue;
            } else if (canStart.getOrDefault(nums[i], 0) > 0) {
                canStart.put(nums[i], canStart.get(nums[i])-1);
                canStart.put(nums[i]+1, canStart.getOrDefault(nums[i]+1, 0)+1);
            } else if (count.getOrDefault(nums[i]+1,0) > 0 && count.getOrDefault(nums[i]+2,0) > 0) {
                count.put(nums[i]+1, count.get(nums[i]+1)-1);
                count.put(nums[i]+2, count.get(nums[i]+2)-1);
                canStart.put(nums[i]+3, canStart.getOrDefault(nums[i]+3, 0)+1);
            } else {
                return false;
            }
            count.put(nums[i], count.get(nums[i])-1);
        }
        return true;
    }
}
