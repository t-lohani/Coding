/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.
 * */

package array;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] replica = (int[]) nums.clone();
        Arrays.sort(replica);
        
        int[] answer = new int[2];
        int head = 0;
        int tail = replica.length-1;
        int sum;
        int num1=Integer.MAX_VALUE, num2=Integer.MAX_VALUE;
        
        while(head < tail) {
            sum = replica[head] + replica[tail];
            if(sum==target) {
                num1 = replica[head];
                num2 = replica[tail];
                break;
            } else if(sum < target) {
                head++;
            } else if(sum > target) {
                tail--;
            }
        }
        
        if(num1!=Integer.MAX_VALUE) {
                for(int i=0, j=nums.length-1; i<nums.length && j>=0; i++, j--) {
                if(nums[i]==num1)
                    answer[0] = i;
                if(nums[j]==num2)
                    answer[1] = j;
            }
        } else {
            answer[0] = 0;
            answer[0] = 0;
        }
        return answer;
    }
    
    public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] answer = twoSum(nums, target);
		
		System.out.println("Index1 : " + answer[0]);
		System.out.println("Index2 : " + answer[1]);
	}
}
