/*
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.
 * */

package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> ans = findDuplicates(nums);
		
		for (int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<Integer>();
        
        for (int i=0; i<nums.length; i++) {
            int temp;
            if (nums[i] < 0) {
                temp = (-1*nums[i])-1;
            } else {
                temp = (nums[i]-1);
            }
        
            if (nums[temp] < 0) {
                answer.add(temp+1);
            } else {
                nums[temp] = -nums[temp];
            }
        }
        
        return answer;
    }
}
