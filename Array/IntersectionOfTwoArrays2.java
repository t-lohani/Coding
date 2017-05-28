/*
 *  Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

 * */

package array;

import java.util.ArrayList;

public class IntersectionOfTwoArrays2 {

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		int[] answer = intersect(nums1, nums2);
		
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length==0 || nums2.length==0)
            return new int[0];
        
        ArrayList<Integer> listInteger = new ArrayList<Integer>();
        int[] intersectionArray;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for(int i=0; i<nums1.length; i++) {
            if(min>nums1[i])
                min = nums1[i];
            
            if(max<nums1[i])
                max = nums1[i];
        }
        
        int[] count1 = new int[max-min+1];
        int[] count2 = new int[max-min+1];
        
        for(int i=0; i<nums1.length; i++) {
            count1[nums1[i]-min]++;
        }
        
        for(int i=0; i<nums2.length; i++) {
            if(nums2[i]-min>=0 && nums2[i]-min<count2.length)
                count2[nums2[i]-min]++;
        }
        
        for(int i=0; i<count1.length; i++) {
            if(count1[i]!=0 && count2[i]!=0) {
                int noOfDuplicates = count1[i]<count2[i]?count1[i]:count2[i];
                while(noOfDuplicates>0) {
                    listInteger.add(i+min);
                    noOfDuplicates--;
                }
            }   
        }
        
        intersectionArray = new int[listInteger.size()];
        for(int i=0; i<intersectionArray.length; i++) {
            intersectionArray[i] = listInteger.get(i);
        }
        
        return intersectionArray;
    }
}
