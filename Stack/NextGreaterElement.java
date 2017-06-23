/*
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * */

package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] findNums = {3, 2, 9, 18};
		int[] nums = {2, 1, 3, 7, 5, 9, 13, 18, 4};
		int[] ans = nextGreaterElement(findNums, nums);
		
		for (int i=0; i<ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[findNums.length];
        int numLen = nums.length;
        int findLen = findNums.length;
        
        for (int i=0; i<numLen; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        
        for (int i=0; i<findLen; i++) {
            answer[i] = map.getOrDefault(findNums[i], -1);
        }
        
        return answer;
    }
}
