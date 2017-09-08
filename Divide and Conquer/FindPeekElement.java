package divideandconquer;

public class FindPeekElement {

	public static void main(String[] args) {
		int[] nums = {1,2,5,4,7,6,8};
		System.out.println(findPeakElement(nums));
	}

	public static int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }
    
    public static int binarySearch(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        } else {
            int mid1 = (start+end)/2;
            int mid2 = mid1+1;
            
            if (nums[mid1] > nums[mid2]) {
                return binarySearch(nums, start, mid1);
            } else {
                return binarySearch(nums, mid2, end);
            }
        }
    }
}
