/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
The number of elements initialized in nums1 and nums2 are m and n respectively.
 * */

package array;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = new int[12];
		nums1[0] = 1;
		nums1[1] = 5;
		nums1[2] = 7;
		nums1[3] = 9;
		nums1[4] = 11;
		nums1[5] = 14;
		
		int[] nums2 = {2,5,7,8,12,15};
		
		merge(nums1, 12, nums2, nums2.length);
		
		for (int i=0; i<nums1.length; i++) {
			System.out.print(nums1[i] + " ");
		}
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0){
            return;
        }
        int index = nums1.length-1;
        int num1Ind = m-1;
        int num2Ind = n-1;
        
        while(index >= 0 && num1Ind >= 0 && num2Ind >= 0){
            if(nums1[num1Ind] > nums2[num2Ind]){
                nums1[index]  = nums1[num1Ind];
                num1Ind--;
            }else{
                nums1[index]  = nums2[num2Ind];
                num2Ind--;
            }
            index--;
        }
        while(num2Ind >= 0){
            nums1[num2Ind]  = nums2[num2Ind];
            num2Ind--;
        }
    }

}
