/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 * */

package array;

public class SearchInsertPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		int target = 5;
		System.out.println(searchInsert(nums, target));
	}
	
	public static int searchInsert(int[] nums, int target) {
        if(nums.length==0 || target<nums[0])
            return 0;
        
        if(target>nums[nums.length-1])
            return nums.length;
            
        return binarySearch(0, nums.length-1, target, nums);
    }
    
    public static int binarySearch(int start, int end, int target, int[] numArray) {
        int middle = (start+end)/2;
        
        if(numArray[middle]==target)
            return middle;
        
        if(start==end) {
            if(numArray[middle]>target)
                return middle;
            else
                return middle+1;
        } else {
            if(numArray[middle]>target) {
                if(middle-1>=start)
                    return binarySearch(start, middle-1, target, numArray);
                else
                    return binarySearch(start, start, target, numArray);
            }
            else {
                if(middle+1<=end)
                    return binarySearch(middle+1, end, target, numArray);
                else
                    return binarySearch(end, end, target, numArray);
            }
        }
    }

}
