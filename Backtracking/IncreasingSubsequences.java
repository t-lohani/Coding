package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {

	public static void main(String[] args) {
		int[] nums = {4,6,7,7};
		List<List<Integer>> ans = findSubsequences(nums);
		
		for (List<Integer> list : ans) {
			for (int i=0; i<list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}

	static Set<List<Integer>> set = new HashSet<>();
    
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list = new ArrayList<>();
        backtrack(nums, list, 0);
        return new ArrayList(set);
    }
    
    public static void backtrack(int[] nums, List<Integer> list, int pos) {
        if (list.size() > 1) {
            set.add(new ArrayList(list));
        }
        
        for (int i=pos; i<nums.length; i++) {
            if (list.size() == 0 || list.get(list.size()-1) <= nums[i]) {
                list.add(nums[i]);
                backtrack(nums, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
