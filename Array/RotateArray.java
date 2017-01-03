/*
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * */

package array;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		rotate(nums, k);
		
		for (int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	public static void rotate(int[] nums, int k) {
        
        int length = nums.length;
        
        while(k>length) {
            k=k%length;
        }
        
        reverse(nums, 0, length-k-1);
        reverse(nums, length-k, length-1);
        reverse(nums, 0, length-1);
    }
    
    public static void reverse(int[] array, int head, int tail) {
        int temp;
        while(head<tail) {
            temp = array[head];
            array[head] = array[tail];
            array[tail] = temp;
            head++;
            tail--;
        }
    }

}
