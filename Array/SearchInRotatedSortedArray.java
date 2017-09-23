package array;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,8,9,10,11,12,0,1,2,3};
		System.out.println(search(nums, 1));
	}

	public static int search(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len-1;
        
        while (start < end) {
            int mid = (start+end)/2;
            if (nums[mid] > nums[end]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        
        int rot = start;
        start = 0;
        end = len-1;
        
        while (start <= end) {
            int mid = (start + end)/2;
            int newMid = (mid + rot)%len;
            
            if (nums[newMid] == target) {
                return newMid;
            }
            
            if (nums[newMid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        
        return -1;
    }
}
