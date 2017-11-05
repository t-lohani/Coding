package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> ans = fourSum(nums, target);
		
		for (List<Integer> list : ans) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        
        if (nums.length < 4) {
            return answer;
        }
        
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        
        while (i<len-3) {
            int l = len-1;
            
            while (l-i>2) {
                int j = i+1;
                int k = l-1;
                while (j < k) {
                    if ((nums[i] + nums[j] + nums[k] + nums[l]) == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        answer.add(list);
                        while (j < k && nums[j] == nums[j+1]) j++;
                        while (j < k && nums[k] == nums[k-1]) k--;
                        j++;
                        k--;
                    } else if ((nums[i] + nums[j] + nums[k] + nums[l]) > target) {
                        while (j < k && nums[k] == nums[k-1]) k--;
                        k--;
                    } else if ((nums[i] + nums[j] + nums[k] + nums[l]) < target) {
                        while (j < k && nums[j] == nums[j+1]) j++;
                        j++;
                    }
                }
                while (l-i>2 && nums[l] == nums[l-1])
                    l--;
                l--;
            }
            
            while (i<len-3 && nums[i] == nums[i+1])
                i++;
            i++;
        }
        
        return answer;
    }
}
