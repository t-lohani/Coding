/*
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.
 * */

package array;

public class TwoSum2 {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] answer = twoSum(nums, target);
		
		System.out.println("Index1 : " + answer[0]);
		System.out.println("Index2 : " + answer[1]);
	}
	
	public static int[] twoSum(int[] numbers, int target) {
        if(numbers.length==0 || numbers.length==1)
            return null;
            
        int ind1 = 0;
        int ind2 = numbers.length-1;
        int ans[] = new int[2];
        
        while(ind1<ind2) {
            if(numbers[ind1]+numbers[ind2]==target) {
                ans[0] = ind1+1;
                ans[1] = ind2+1;
                return ans;
            } else if(numbers[ind1]+numbers[ind2]>target) {
                ind2--;
            } else {
                ind1++;
            }
        }
        
        return ans;
    }

}
