/*
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
 * */

package hashtable;

import java.util.ArrayList;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] ans = intersection(nums1, nums2);
		
		for (int i=0; i<ans.length; i++) {
			System.out.println(ans[i] + " ");
		}
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null)
            return nums1;
            
        if(nums2==null)
            return nums2;
            
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        int[] hashArray;
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        for(int i=0; i<nums1.length; i++) {
            if(nums1[i] > max)
                max = nums1[i];
            if(nums1[i] < min)
                min = nums1[i];
        }
        
        hashArray = new int[max-min+1];
        
        for(int i=0; i<nums1.length; i++) {
            hashArray[nums1[i]-min] = -1;
        }
        
        for(int i=0; i<nums2.length; i++) {
            if(nums2[i]-min<hashArray.length && nums2[i]-min>=0 && hashArray[nums2[i]-min]==-1) {
                hashArray[nums2[i]-min] = 1;
            }
        }   
        
        for(int i=0; i<hashArray.length; i++) {
            if(hashArray[i]==1)
                answer.add(min+i);
        }
        
        int[] finalAnswer = new int[answer.size()];
        
        for(int i=0; i<finalAnswer.length; i++) {
            finalAnswer[i] = answer.get(i);
        }
        
        return finalAnswer;
     }

}
