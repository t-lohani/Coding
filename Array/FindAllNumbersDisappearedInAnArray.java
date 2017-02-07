/*
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * */

package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> ans = findDisappearedNumbers(nums);
		
		for (int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        
        if (nums.length == 0) {
            return answer;
        }
        
        for (int i=0; i<nums.length; i++) {
            int ind = nums[i];
            
            if (ind < 0) {
                ind = ind*-1;
            }
            
            if (nums[ind-1] > 0) {
                nums[ind-1] = nums[ind-1]*-1;
            }
        }
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                answer.add(i+1);
            }
        }
        
        return answer;
    }

}
