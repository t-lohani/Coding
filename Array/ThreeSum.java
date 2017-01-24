/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * */

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> ans = threeSum(nums);
		
		for (int i=0; i<ans.size(); i++) {
			for (int j=0; j<ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        
        if (nums.length < 3) {
            return answer;
        }
        
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int j = i+1;
                int k = nums.length-1;
                while (j < k) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        answer.add(list);
                        while (j < k && nums[j] == nums[j+1]) j++;
                        while (j < k && nums[k] == nums[k-1]) k--;
                        j++;
                        k--;
                    } else if ((nums[i] + nums[j] + nums[k]) > 0) {
                        k--;
                    } else if ((nums[i] + nums[j] + nums[k]) < 0) {
                        j++;
                    }
                }
            }
        }
        
        return answer;
    }
}
