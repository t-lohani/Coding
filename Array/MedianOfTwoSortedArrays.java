package array;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[len1 + len2];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) {
                arr[k] = nums1[i++];
            } else {
                arr[k] = nums2[j++];
            }
            k++;
        }
        
        if (i == len1) {
            while (j < len2) {
                arr[k] = nums2[j++];
                k++;
            }
        } else {
            while (i < len1) {
                arr[k] = nums1[i++];
                k++;
            }
        }
        
        if (arr.length%2 == 0) {
            return (double)(arr[arr.length/2] + arr[(arr.length/2)-1])/2;
        } else {
            return arr[arr.length/2];
        }
    }
}
