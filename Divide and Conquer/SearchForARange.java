package divideandconquer;

public class SearchForARange {

	public static void main(String[] args) {
		int[] nums = {5,6,7,7,7,8,8,8,8,8,8,10};
		int target = 8;
		
		int[] ans = searchRange(nums, target);
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

	public static int[] searchRange(int[] nums, int target) {
        int[] answer = {-1, -1};
        if (nums.length == 0)
            return answer;
        
        int start = 0;
        int end = nums.length-1;
        
        while (start < end) {
            int mid = start + (end-start)/2;
            if (nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        
        if (nums[end] == target)
            answer[0] = end;
        
        start = 0;
        end = nums.length-1;
        while (start < end) {
            int mid = (start + (end-start)/2)+1;
            if (nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid;
            }
        }
        
        if (nums[start] == target)
            answer[1] = start;
        
        return answer;
    }
}
